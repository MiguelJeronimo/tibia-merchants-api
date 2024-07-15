package com.miguel.tibia_merchants_api.repository

import Tibia.Tibia
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog
import org.apache.logging.log4j.LogManager

@Suppress("IMPLICIT_CAST_TO_ANY")
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

    fun bodyEquipments(name: String): ArrayList<ItemEquipment>?{
       return try {
           val tibia = Tibia().bodyEquipments(name)
           logger.info("Response repository: $tibia")
           tibia
       } catch (e:Exception){
           logger.fatal("Error repository: ${e.message}")
           null
       }
    }
    fun weapons(name: String): Any? {
        return try {
            val tibia = when(name.lowercase()){
                "axe weapons"-> Tibia().weapons().axesWeapons()
                "club weapons"-> Tibia().weapons().clubWeapons()
                "sword weapons"-> Tibia().weapons().swordsWeapons()
                "rods"-> Tibia().weapons().rods()
                "wands"-> Tibia().weapons().wands()
                "throwing weapons"-> Tibia().weapons().throwingWeapons()
                "bows"-> Tibia().weapons().bows()
                 else->{}
            }
            logger.info("Response repository: $tibia")
            tibia
        } catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }
}