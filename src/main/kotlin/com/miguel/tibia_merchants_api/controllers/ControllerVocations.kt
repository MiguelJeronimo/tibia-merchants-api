package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseVocations
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ControllerVocations: KoinComponent {
    private val logger: Logger = LogManager.getLogger(ControllerVocations::class.java)
    private val useCaseVocations: UseCaseVocations by inject()
    @GetMapping("/vocations")
    suspend fun vocations(): ResponseEntity<out Any?> {
        return try {
            logger.info("init petition")
            val vocations = useCaseVocations.vocatons()
            if (vocations != null){
                val response = Response(200, vocations)
                logger.info("Response final: $response")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting vocation list")
                logger.error("Error: $vocations")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }

    @GetMapping("/vocation/{vocation}")
    suspend fun vocation(@PathVariable vocation:String): ResponseEntity<out Any?> {
        return try {
            logger.info("init petition")
            logger.info("Request: $vocation")
            val vocation = useCaseVocations.vocation(vocation)
            if (vocation != null){
                val response = Response(200, vocation)
                logger.info("Response final: ${response.statusCode}")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting vocation")
                logger.error("Error Final: $vocation")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }
}