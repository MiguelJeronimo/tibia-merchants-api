package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.data.repositories.SpellsRepositoryImp
import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseSpells
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class ControllerSpells {
    private val logger: Logger = LogManager.getLogger(ControllerSpells::class.java)

    @GetMapping("/spells")
    fun spells(): Any?{
        logger.info("init petition")
        return try {
            val repositoryImp = SpellsRepositoryImp(Tibia())
            val useCaseSpells = UseCaseSpells(repositoryImp)
            val spells = useCaseSpells.invokeSpells()
            if (spells != null){
                val response = Response(200, spells)
                logger.info("Response final: $response")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting catalog list")
                logger.error("Error: $error")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e:Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }
}