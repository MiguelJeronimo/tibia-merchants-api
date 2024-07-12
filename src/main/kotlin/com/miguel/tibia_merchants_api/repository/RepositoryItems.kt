package com.miguel.tibia_merchants_api.repository

import Tibia.Tibia
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog
import org.apache.logging.log4j.LogManager

class RepositoryItems {
    private val logger = LogManager.getLogger(RepositoryItems::class.java)
    fun items(): ItemsCatalog? {
        return try {
            val tibia = Tibia().items().items()
            logger.info("Response repository: $tibia")
            tibia
        }catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    fun item(name: String): ArrayList<ItemEquipment>?{
       return try {
           val tibia = Tibia().item(name)
           logger.info("Response repository: $tibia")
           tibia
       } catch (e:Exception){
           logger.fatal("Error repository: ${e.message}")
           null
       }
    }
}