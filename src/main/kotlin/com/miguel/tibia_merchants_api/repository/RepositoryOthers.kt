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

    fun othersEquipments(name: String): Any? {
        return try {
            val tibia = Tibia().toolsEquipments(name)
            tibia
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    fun otherItems(name:String): Any? {
        return try {
            val tibia = Tibia().otherItems(name)
            tibia
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }
}