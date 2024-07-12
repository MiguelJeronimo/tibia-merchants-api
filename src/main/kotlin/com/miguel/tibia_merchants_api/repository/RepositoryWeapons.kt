package com.miguel.tibia_merchants_api.repository

import API.Tibia.models.Weapons
import Tibia.Tibia
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class RepositoryWeapons {
    private val logger: Logger = LogManager.getLogger(RepositoryWeapons::class.java)
    fun weapons(): Weapons? {
        try {
            val tibia = Tibia().weapons().weapons()
            Tibia().weapons().clubWeapons()
            logger.info("weapon response: $tibia")
            return tibia
        } catch (e:Exception){
            logger.error("weapon error: ${e.message}")
            return null
        }
    }
}