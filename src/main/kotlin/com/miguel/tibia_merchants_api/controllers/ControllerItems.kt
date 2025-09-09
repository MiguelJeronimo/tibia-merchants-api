package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.post.BodyItems
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseItems
import org.apache.logging.log4j.LogManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class ControllerItems: KoinComponent {
    private val logger = LogManager.getLogger(ControllerItems::class.java)
    private val useCaseItems: UseCaseItems by inject()
    @GetMapping("/items")
    suspend fun items(): Any {
        return try {
            logger.info("init petition")
            val repository = useCaseItems.items()
            if (repository!= null){
                val response = Response(200, repository)
                logger.info("Response succeful....")
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
    suspend fun item(@RequestBody bodyItems: BodyItems): Any {
        return try {
            logger.info("Request: $bodyItems")
            val title = bodyItems.title
            val name = bodyItems.name
            logger.info("init petition")
            if (title != null && name != null){
                val repository = useCaseItems.type(title, name)
                println("REPOSITY"+repository)
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
    @GetMapping("/item/{name}")
    suspend fun item(@PathVariable name: String): Any?{
        return try {
            logger.info("Request: $name")
            logger.info("init petition")
            if (name != null){
                val repository = useCaseItems.item(name)
                if (repository != null){
                    val response = Response(200, repository)
                    logger.info("Response succeful....")
                    ResponseEntity.ok().body(response)
                } else {
                    val error = Errors(400, "Error getting $name information")
                    logger.error("Error: $repository")
                    ResponseEntity.badRequest().body(error)
                }
            } else {
                val error = Errors(400, "Error send data: ")
                logger.error("Error: $name")
                error
            }
        }catch(e:Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }
}