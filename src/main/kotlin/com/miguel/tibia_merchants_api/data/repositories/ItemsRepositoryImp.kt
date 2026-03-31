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
    override suspend fun items(html: String): ItemsCatalog? {
        return try {
            withContext(Dispatchers.IO){
                val items = tibia.items().items(html = html)
                logger.info("Response repository: $items")
                items
            }
        }catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun item(name: String, html: String): Profile? {
        return try {
            withContext(Dispatchers.IO){
                val items = tibia.itemProfileItems(name, html = html)
                logger.info("Response repository: $items")
                items
            }
        }catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun bodyEquipments(name: String, html: String): ArrayList<ItemEquipment>? {
        return try {
            withContext(Dispatchers.IO){
                val bodyEquipments = tibia.bodyEquipments(name, html = html)
                logger.info("Response repository: $bodyEquipments")
                bodyEquipments
            }
        } catch (e:Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun weapons(name: String, html: String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val weapons = when(name.lowercase()){
                    "axe weapons"-> tibia.weapons(html = html).axesWeapons()
                    "club weapons"-> tibia.weapons(html = html).clubWeapons()
                    "sword weapons"-> tibia.weapons(html = html).swordsWeapons()
                    "rods"-> tibia.weapons(html = html).rods()
                    "wands"-> tibia.weapons(html = html).wands()
                    "throwing weapons"-> tibia.weapons(html = html).throwingWeapons()
                    "bows"-> tibia.weapons(html = html).bows()
                    "bow ammunition"-> tibia.weapons(html = html).arrows()
                    "crossbows"-> tibia.weapons(html = html).crowBows()
                    "crossbow ammunition"-> tibia.weapons(html = html).bolts()
                    "old wands"-> tibia.weapons(html = html).oldWands()
                    "old wands (deprecated)"-> tibia.weapons(html = html).oldWands()
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
                val weapons = tibia.weapons(html = "").weapons()
                logger.info("weapon response: $weapons")
                weapons
            }
        } catch (e:Exception){
            logger.error("weapon error: ${e.message}")
            null
        }
    }

    override suspend fun household(name: String, html: String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val houseHold = tibia.household(name, html = html)
                logger.info("Response repository: $houseHold")
                houseHold
            }
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun others(name: String, html: String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val others = tibia.others(name, html = html)
                logger.info("Response repository: $others")
                others
            }
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun othersEquipments(name: String, html: String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val others = tibia.toolsEquipments(name, html = html)
                logger.info("Response repository: $others")
                others
            }
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }

    override suspend fun otherItems(name: String, html: String): Any? {
        return try {
            withContext(Dispatchers.IO){
                val others = tibia.otherItems(name, html = html)
                logger.info("Response repository: $others")
                others
            }
        }catch (e: Exception){
            logger.fatal("Error repository: ${e.message}")
            null
        }
    }
}