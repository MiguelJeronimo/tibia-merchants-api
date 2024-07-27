package com.miguel.tibia_merchants_api.repository

import Tibia.Tibia
import org.apache.logging.log4j.LogManager

class RepositoryHousehold {
    private val logger = LogManager.getLogger(RepositoryHousehold::class.java)
    fun household(name: String): Any? {
        return try {
            val tibia = Tibia().household(name)
            logger.info("Response repository: $tibia")
            tibia
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }
}