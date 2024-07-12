package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.model.Tibia.Errors
import com.miguel.tibia_merchants_api.model.Tibia.Response
import com.miguel.tibia_merchants_api.repository.RepositoryItems
import org.apache.logging.log4j.LogManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/item/{name}")
    fun item(@PathVariable name: String): Any {
        return try {
            val repository = RepositoryItems().item(name)
            if (repository != null){
                val response = Response(200, repository)
                logger.info("Reponse final: $response")
                response
            } else {
                val error = Errors(400, "Error getting catalog list")
                logger.error("Error: $repository")
                error
            }
        }catch(e:Exception){
            logger.fatal("Error: ${e.message}")
            Errors(500, "Fatal Error, contact to support")
        }
    }
}