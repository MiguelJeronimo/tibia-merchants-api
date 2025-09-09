package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.domain.usecase.UseCaseCatalog
import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
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
class ControllerCatalog: KoinComponent {
    private val logger: Logger = LogManager.getLogger(ControllerCatalog::class.java)
    private val useCaseCatalog: UseCaseCatalog by inject()
    @GetMapping("/catalog")
    suspend fun catalog(): Any {
        return try {
            logger.info("init petition")
            val catalog = useCaseCatalog.catalog()
            if (catalog != null){
                val response = Response(200, catalog)
                logger.info("Response final: $response")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting catalog list")
                logger.error("Error: $error")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }

}