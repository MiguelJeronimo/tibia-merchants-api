package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.model.Tibia.Errors
import com.miguel.tibia_merchants_api.model.Tibia.POST.BodyItems
import com.miguel.tibia_merchants_api.model.Tibia.Response
import com.miguel.tibia_merchants_api.repository.RepositoryItems
import org.apache.logging.log4j.LogManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class ControllerItems {
    private val logger = LogManager.getLogger(ControllerItems::class.java)
    @GetMapping("/items")
    fun items(): Any {
        try {
            logger.info("init petition")
            val repository = RepositoryItems().items()
            if (repository!= null){
                val response = Response(200, repository)
                logger.info("Reponse final: $response")
                return response
            }else{
                val error = Errors(400, "Error getting catalog list")
                logger.error("Error: $repository")
                return error
            }
        }catch (e:Exception){
            logger.fatal("Error: ${e.message}")
            return Errors(500, "Fatal Error, contact to support")
        }
    }

    @GetMapping("/items/type/")
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
                    "household items"-> "RepositoryItems().item(name)"
                    "plants, animal products, food and frink"-> "RepositoryItems().item(name)"
                    "tools and other equipment"-> "RepositoryItems().item(name)"
                    "other items"-> "RepositoryItems().item(name)"
                    ""-> "RepositoryItems().item(name)"
                    else -> {}
                }
                if (repository != null){
                    val response = Response(200, repository)
                    logger.info("Reponse final: $response")
                    response
                } else {
                    val error = Errors(400, "Error getting $name list")
                    logger.error("Error: $repository")
                    error
                }
            } else {
                val error = Errors(400, "Error send data: ")
                logger.error("Error: $bodyItems")
                error
            }
        }catch(e:Exception){
            logger.fatal("Error: ${e.message}")
            Errors(500, "Fatal Error, contact to support")
        }
    }
}