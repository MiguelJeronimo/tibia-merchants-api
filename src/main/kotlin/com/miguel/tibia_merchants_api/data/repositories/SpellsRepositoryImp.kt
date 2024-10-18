package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.controllers.ControllerSpells
import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.domain.models.spells.Spells
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class SpellsRepositoryImp(private val tibia: Tibia): SpellsRepository {
    private val logger: Logger = LogManager.getLogger(SpellsRepositoryImp::class.java)
    override fun spells(): Spells? {
        return try {
            val spells = tibia.spells()
            logger.info("RESPONSE Spells: $spells")
            spells
        } catch (e: Exception){
            logger.fatal("Error npc: ${e.message}")
            null
        }
    }
}