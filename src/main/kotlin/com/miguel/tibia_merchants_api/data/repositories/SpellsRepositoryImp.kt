package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.domain.models.spells.Spells
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class SpellsRepositoryImp(private val tibia: Tibia): SpellsRepository {
    private val logger: Logger = LogManager.getLogger(SpellsRepositoryImp::class.java)
    override suspend fun spells(html: String): Spells? {
        return try {
            withContext(Dispatchers.IO){
                val spells = tibia.spells(html = html)
                logger.info("RESPONSE Spells: $spells")
                spells
            }
        } catch (e: Exception){
            logger.fatal("Error npc: ${e.message}")
            null
        }
    }
}