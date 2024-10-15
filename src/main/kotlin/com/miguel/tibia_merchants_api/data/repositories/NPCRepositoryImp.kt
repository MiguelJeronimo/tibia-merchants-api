package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.data.network.Tibia
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class NPCRepositoryImp(private val tibia: Tibia): NPCRepository{
    private val logger: Logger = LogManager.getLogger(NPCRepositoryImp::class.java)

    override fun npc(name:String): Any? {
        return try {
            val npc = tibia.npcsDefault(name)
            logger.info("RESPONSE NPC: $npc")
            npc
        }catch (e: Exception){
            logger.fatal("Error npc: ${e.message}")
            null
        }
    }

}