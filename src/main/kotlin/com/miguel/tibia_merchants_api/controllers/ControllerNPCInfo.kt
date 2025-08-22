package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseNPC
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
@RequestMapping("api/v1")
class ControllerNPCInfo: KoinComponent {
    private val logger: Logger = LogManager.getLogger(ControllerSpells::class.java)
    val useCaseNPC: UseCaseNPC by inject()
    @GetMapping("/npc/{name}")
    suspend fun npcInfo(@PathVariable name:String):Any?{
        logger.info("init petition")
        return try {
            val npcs = useCaseNPC.npcInfo(name = name)
            if (npcs != null){
                val response = Response(200, npcs)
                logger.info("Response final: $response")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "NPC is not exits")
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