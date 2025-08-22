package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Vocation
import API.Tibia.models.Vocations
import com.miguel.tibia_merchants_api.data.network.Tibia
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class VocationsRepositoryImp(private val tibia: Tibia): VocationsRepository {
    private val logger: Logger = LogManager.getLogger(VocationsRepositoryImp::class.java)

    override suspend fun vocations(): ArrayList<Vocations>? {
        return try {
            withContext(Dispatchers.IO){
                val vocation = tibia.vocations().vocationList()
                logger.info("Vocations List response: $vocation")
                vocation
            }
        } catch (e:Exception){
            logger.error("Error vocation: ${e.message}")
            null
        }
    }

    override suspend fun sorcerer(): Vocation? {
        return try {
            withContext(Dispatchers.IO){
                val sorcerer = tibia.vocations().sorcerer()
                logger.info("sorcerer repository: $sorcerer")
                sorcerer
            }
        } catch (e:Exception){
            logger.error("Error sorcerer repository: ${e.message}")
            null
        }
    }

    override suspend fun druid(): Vocation? {
        return try {
            withContext(Dispatchers.IO){
                val druid = tibia.vocations().druid()
                logger.info("druid repository: $druid")
                druid
            }
        } catch (e:Exception){
            logger.error("Error druid repository: ${e.message}")
            null
        }
    }

    override suspend fun knight(): Vocation? {
        return try {
            withContext(Dispatchers.IO){
                val knight = tibia.vocations().knight()
                logger.info("knight repository: $knight")
                knight
            }
        } catch (e:Exception){
            logger.error("Error repository repository: ${e.message}")
            null
        }
    }

    override suspend fun paladin(): Vocation? {
        return try {
            withContext(Dispatchers.IO){
                val paladin = tibia.vocations().paladin()
                logger.info("paladin repository: $paladin")
                paladin
            }
        } catch (e:Exception){
            logger.error("Error paladin repository: ${e.message}")
            null
        }
    }
}