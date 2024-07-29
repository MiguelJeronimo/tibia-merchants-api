package com.miguel.tibia_merchants_api.repository

import Tibia.Tibia
import org.apache.logging.log4j.LogManager

class RepositoryOthers {
    private val logger = LogManager.getLogger(RepositoryOthers::class.java)
    fun others(name: String): Any? {
        return try {
            val tibia = Tibia().others(name)
            tibia
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }
}