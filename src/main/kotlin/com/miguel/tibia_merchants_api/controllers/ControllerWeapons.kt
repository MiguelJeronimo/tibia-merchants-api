package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.model.Tibia.Errors
import com.miguel.tibia_merchants_api.model.Tibia.Response
import com.miguel.tibia_merchants_api.repository.RepositoryWeapons
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class ControllerWeapons {
    private val logger: Logger = LogManager.getLogger(ControllerWeapons::class.java)
    @GetMapping("/weapons")
    fun weapons(): Any {
        return try {
            logger.info("init petition")
            val weapons = RepositoryWeapons().weapons()
            if (weapons != null){
                val response = Response(200, weapons)
                logger.info("Response final: $response")
                response
            }else{
                val error = Errors(400, "Error getting weapon list")
                logger.error("Error: $error")
                error
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            Errors(500, "Fatal Error, contact to support")
        }
    }
}