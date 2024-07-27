package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.model.Tibia.Errors
import com.miguel.tibia_merchants_api.model.Tibia.Response
import com.miguel.tibia_merchants_api.repository.RepositoryCatalog
import com.miguel.tibia_merchants_api.repository.RepositoryVocations
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerVocations {
    private val logger: Logger = LogManager.getLogger(ControllerVocations::class.java)
    @GetMapping("api/v1/vocations")
    fun vocations(): Any {
        return try {
            logger.info("init petition")
            val catalog = RepositoryVocations().vocations()
            if (catalog != null){
                val response = Response(200, catalog)
                logger.info("Response final: $response")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting vocation list")
                logger.error("Error: $catalog")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }

    @GetMapping("api/v1/vocation/{vocation}")
    fun vocation(@PathVariable vocation:String): Any {
        return try {
            logger.info("init petition")
            logger.info("Request: $vocation")
            val catalog = RepositoryVocations()
            val vocations = when(vocation.lowercase()){
                "sorcerer" -> catalog.sorcerer()
                "druid" -> catalog.druid()
                "knight" -> catalog.knight()
                "paladin" -> catalog.paladin()
                else -> {null}
            }
            if (vocations != null){
                val response = Response(200, vocations)
                logger.info("Response final: $response")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting vocation")
                logger.error("Error Final: $vocations")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }
}