package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.domain.models.npc.NPCInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class NPCRepositoryImp(private val tibia: Tibia): NPCRepository{
    private val logger: Logger = LogManager.getLogger(NPCRepositoryImp::class.java)

    override suspend fun npc(name:String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val npc = tibia.npcsDefault(name)
                logger.info("RESPONSE NPC: $npc")
                npc
            }
        }catch (e: Exception){
            logger.fatal("Error npc: ${e.message}")
            null
        }
    }

    override suspend fun npcInfo(name: String): NPCInfo? {
        return try {
            withContext(Dispatchers.IO){
                val npc = tibia.npc(name)
                logger.info("RESPONSE NPCINFO: $npc")
                npc
            }
        }catch (e: Exception){
            logger.fatal("Error npc info: ${e.message}")
            null
        }
    }
}