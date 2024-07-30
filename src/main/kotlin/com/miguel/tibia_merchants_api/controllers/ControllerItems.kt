package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.model.Tibia.Errors
import com.miguel.tibia_merchants_api.model.Tibia.POST.BodyItems
import com.miguel.tibia_merchants_api.model.Tibia.Response
import com.miguel.tibia_merchants_api.repository.RepositoryHousehold
import com.miguel.tibia_merchants_api.repository.RepositoryItems
import com.miguel.tibia_merchants_api.repository.RepositoryOthers
import org.apache.logging.log4j.LogManager
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1")
class ControllerItems {
    private val logger = LogManager.getLogger(ControllerItems::class.java)
    @GetMapping("/items")
    fun items(): Any {
        return try {
            logger.info("init petition")
            val repository = RepositoryItems().items()
            if (repository!= null){
                val response = Response(200, repository)
                logger.info("Reponse final: $response")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting catalog list")
                logger.error("Error: $repository")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e:Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }

    @PostMapping("/items/type/")
    fun item(@RequestBody bodyItems: BodyItems): Any {
        return try {
            logger.info("Request: $bodyItems")
            val title = bodyItems.title
            val name = bodyItems.name
            logger.info("init petition")
            if (title != null && name != null){
                val repository = when(title.lowercase()){
                    "body equipment"-> RepositoryItems().bodyEquipments(name)
                    "weapons"-> RepositoryItems().weapons(name)
                    "household items"-> RepositoryHousehold().household(name)
                    "plants, animal products, food and drink"-> RepositoryOthers().others(name)
                    "tools and other equipment"-> RepositoryOthers().othersEquipments(name)
                    "other items"-> RepositoryOthers().otherItems(name)
                    ""-> "RepositoryItems().item(name)"
                    else -> {}
                }
                if (repository != null){
                    val response = Response(200, repository)
                    logger.info("Response succeful....")
                    ResponseEntity.ok().body(response)
                } else {
                    val error = Errors(400, "Error getting $name list")
                    logger.error("Error: $repository")
                    ResponseEntity.badRequest().body(error)
                }
            } else {
                val error = Errors(400, "Error send data: ")
                logger.error("Error: $bodyItems")
                error
            }
        }catch(e:Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }
}