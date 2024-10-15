package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Weapons
import com.miguel.tibia_merchants_api.data.network.Tibia
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog
import org.apache.logging.log4j.LogManager

@Suppress("IMPLICIT_CAST_TO_ANY")
class ItemsRepositoryImp(private val tibia: Tibia): ItemsRepository {
    private val logger = LogManager.getLogger(ItemsRepositoryImp::class.java)
    override fun items(): ItemsCatalog? {
        return try {
            val items = tibia.items().items()
            logger.info("Response repository: $items")
            items
        }catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override fun bodyEquipments(name: String): ArrayList<ItemEquipment>? {
        return try {
            val bodyEquipments = tibia.bodyEquipments(name)
            logger.info("Response repository: $bodyEquipments")
            bodyEquipments
        } catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override fun weapons(name: String): Any? {
        return try {
            val weapons = when(name.lowercase()){
                "axe weapons"-> tibia.weapons().axesWeapons()
                "club weapons"-> tibia.weapons().clubWeapons()
                "sword weapons"-> tibia.weapons().swordsWeapons()
                "rods"-> tibia.weapons().rods()
                "wands"-> tibia.weapons().wands()
                "throwing weapons"-> tibia.weapons().throwingWeapons()
                "bows"-> tibia.weapons().bows()
                "bow ammunition"-> tibia.weapons().arrows()
                "crossbows"-> tibia.weapons().crowBows()
                "crossbow ammunition"-> tibia.weapons().bolts()
                "old wands"-> tibia.weapons().oldWands()
                "old wands (deprecated)"-> tibia.weapons().oldWands()
                else-> null
            }
            logger.info("Response repository: $weapons")
            weapons
        } catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }
    override fun weapons(): Weapons? {
        try {
            val weapons = tibia.weapons().weapons()
            logger.info("weapon response: $weapons")
            return weapons
        } catch (e:Exception){
            logger.error("weapon error: ${e.message}")
            return null
        }
    }

    override fun household(name: String): Any? {
        return try {
            val houseHold = tibia.household(name)
            logger.info("Response repository: $houseHold")
            houseHold
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override fun others(name: String): Any? {
        return try {
            val others = tibia.others(name)
            logger.info("Response repository: $others")
            others
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override fun othersEquipments(name: String): Any? {
        return try {
            val others = tibia.toolsEquipments(name)
            logger.info("Response repository: $others")
            tibia
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override fun otherItems(name: String): Any? {
        return try {
            val others = tibia.otherItems(name)
            logger.info("Response repository: $others")
            tibia
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }
}