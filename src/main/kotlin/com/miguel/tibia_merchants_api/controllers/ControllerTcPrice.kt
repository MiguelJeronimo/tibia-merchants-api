package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseTrade
import com.miguel.tibia_merchants_api.utils.exceptions.ResourceNotFoundException
import org.apache.logging.log4j.LogManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ControllerTcPrice: KoinComponent {
    private val logger = LogManager.getLogger(this::class.java)
    private val useCase: UseCaseTrade by inject()

    @GetMapping("/tibiaCoin/price")
    suspend fun tibiaCoinsPrice(): ResponseEntity<out Any?> {
        return try {
            val items = useCase.getTibiaCoinPrices()
            val response = Response(200, items)
            ResponseEntity.ok().body(response)
        }
        catch (e: ResourceNotFoundException){
            logger.error(e)
            val error = Errors(400, "Resource not found")
            ResponseEntity.badRequest().body(error)
        }
        catch (e: Exception){
            logger.error(e)
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }
}