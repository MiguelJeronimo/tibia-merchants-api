package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseEmbuiments
import org.apache.logging.log4j.LogManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class EmbuinmentController: KoinComponent {
    private val logger = LogManager.getLogger(EmbuinmentController::class.java)
private val useCase: UseCaseEmbuiments by inject()

    @GetMapping("/embuinments")
    suspend fun embuiments(): ResponseEntity<out Any?> {
        logger.info("init petition")
        return try{
            val embuiments = useCase.embuiment()
            if (embuiments != null){
                val response = Response(
                    200,
                    embuiments
                )
                ResponseEntity.ok().body(response)
            } else{
                val error = Errors(400, "Error getting embuinments")
                logger.error("Error Final: $embuiments")
                ResponseEntity.badRequest().body(error)
            }
        } catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }

    }
}