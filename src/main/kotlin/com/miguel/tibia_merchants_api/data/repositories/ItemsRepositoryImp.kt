package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Weapons
import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.domain.models.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog
import org.apache.logging.log4j.LogManager

@Suppress("IMPLICIT_CAST_TO_ANY")
class ItemsRepositoryImp(private val tibia: Tibia): ItemsRepository {
    private val logger = LogManager.getLogger(ItemsRepositoryImp::class.java)
    override suspend fun items(): ItemsCatalog? {
        return try {
            withContext(Dispatchers.IO){
                val items = tibia.items().items()
                logger.info("Response repository: $items")
                items
            }
        }catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun item(name: String): Profile? {
        return try {
            withContext(Dispatchers.IO){
                val items = tibia.itemProfileItems(name)
                logger.info("Response repository: $items")
                items
            }
        }catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun bodyEquipments(name: String): ArrayList<ItemEquipment>? {
        return try {
            withContext(Dispatchers.IO){
                val bodyEquipments = tibia.bodyEquipments(name)
                logger.info("Response repository: $bodyEquipments")
                bodyEquipments
            }
        } catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun weapons(name: String): Any? {
        return try {
            withContext(Dispatchers.IO){
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
            }
        } catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }
    override suspend fun weapons(): Weapons? {
        return try {
            withContext(Dispatchers.IO){
                val weapons = tibia.weapons().weapons()
                logger.info("weapon response: $weapons")
                weapons
            }
        } catch (e:Exception){
            logger.error("weapon error: ${e.message}")
            null
        }
    }

    override suspend fun household(name: String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val houseHold = tibia.household(name)
                logger.info("Response repository: $houseHold")
                houseHold
            }
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun others(name: String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val others = tibia.others(name)
                logger.info("Response repository: $others")
                others
            }
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun othersEquipments(name: String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val others = tibia.toolsEquipments(name)
                logger.info("Response repository: $others")
                others
            }
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun otherItems(name: String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val others = tibia.otherItems(name)
                logger.info("Response repository: $others")
                others
            }
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }
}