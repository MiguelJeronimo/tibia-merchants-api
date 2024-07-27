package com.miguel.tibia_merchants_api.controllers
import com.miguel.tibia_merchants_api.model.Tibia.Errors
import com.miguel.tibia_merchants_api.model.Tibia.Response
import com.miguel.tibia_merchants_api.repository.repositoryNPC
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerNPCDefault {
    private val logger: Logger = LogManager.getLogger(ControllerNPCDefault::class.java)
    @GetMapping("api/v1/npcs/{name}")
    fun npcsDefault(@PathVariable name: String): Any?{
        return try {
            logger.info("init petition")
            val npc = repositoryNPC(name).npc()
            if (npc != null){
                val response = Response(200, npc)
                logger.info("Response final: $response")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "NPC is not exits")
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