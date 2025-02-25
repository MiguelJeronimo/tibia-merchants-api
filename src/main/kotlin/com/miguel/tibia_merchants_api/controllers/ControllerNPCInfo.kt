package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.data.repositories.NPCRepositoryImp
import com.miguel.tibia_merchants_api.data.repositories.SpellsRepositoryImp
import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseNPC
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseSpells
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class ControllerNPCInfo {
    private val logger: Logger = LogManager.getLogger(ControllerSpells::class.java)
    @GetMapping("/npc/{name}")
    fun npcInfo(@PathVariable name:String):Any?{
        logger.info("init petition")
        return try {
            val repositoryImp = NPCRepositoryImp(Tibia())
            val useCaseNPC = UseCaseNPC(repositoryImp)
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