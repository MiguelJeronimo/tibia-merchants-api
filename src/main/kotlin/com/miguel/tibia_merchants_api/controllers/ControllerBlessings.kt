package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseBlessings
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ControllerBlessings: KoinComponent {
    private val logger: Logger = LogManager.getLogger(ControllerBlessings::class.java)
    private val useCaseBlessings: UseCaseBlessings by inject()
    @GetMapping("/blessings")
    suspend fun blessings(): Any{
        return try {
            logger.info("init petition")
            val blessings = useCaseBlessings.blessings()
            if (blessings != null){
                val response = Response(200, blessings)
                logger.info("Response final: ${response.statusCode}")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting vocation")
                logger.error("Error Final: $blessings")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }
}