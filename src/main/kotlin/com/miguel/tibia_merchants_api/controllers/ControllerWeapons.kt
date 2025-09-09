package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.data.repositories.ItemsRepositoryImp
import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseItems
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ControllerWeapons {
    private val logger: Logger = LogManager.getLogger(ControllerWeapons::class.java)
    private val repositoryImp = ItemsRepositoryImp(Tibia())
    private val useCase = UseCaseItems(repositoryImp)
    @GetMapping("/weapons")
    suspend fun weapons(): ResponseEntity<out Any?> {
        return try {
            logger.info("init petition")
            val weapons = useCase.weapons()
            if (weapons != null){
                val response = Response(200, weapons)
                logger.info("Response final: ${response.statusCode}")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting weapon list")
                logger.error("Error: $error")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.ok().body(error)
        }
    }
}