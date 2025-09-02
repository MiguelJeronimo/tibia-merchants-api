package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.domain.models.Imbuements
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.logging.log4j.LogManager

class EmbuimentsRepositoryImp(private val tibia: Tibia) : EmbuimentsRepository {
    private val logger = LogManager.getLogger(EmbuimentsRepositoryImp::class.java)
    override suspend fun getEmbuiments(): Imbuements? {
        return try {
            withContext(Dispatchers.IO){
                val tibia = tibia.embuiments()
                logger.info("Embuinments: $tibia")
                tibia
            }
        } catch (e: Exception){
            logger.error("Error: $e")
            null
        }
    }
}