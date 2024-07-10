package com.miguel.tibia_merchants_api.repository

import Tibia.Tibia
import com.miguel.tibia_merchants_api.controllers.ControllerNPCDefault
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class repositoryNPC(val nameNPC: String) {
    val url = "https://tibia.fandom.com/wiki"
    private val logger: Logger = LogManager.getLogger(repositoryNPC::class.java)
    fun npc(): Any? {
        try {
            val tibia = Tibia().npcsDefault(nameNPC)
            logger.info("RESPONSE NPC: $tibia")
            return tibia
        }catch (e: Exception){
            logger.fatal("Error npc: ${e.message}")
            return null
        }
    }
}