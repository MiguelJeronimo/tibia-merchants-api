package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.domain.models.Blessing
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class BlessingsRepositoryImp(private val tibia: Tibia): BlessingsRepository {
    private val logger: Logger = LogManager.getLogger(BlessingsRepositoryImp::class.java)
    override fun blessings(): Blessing? {
        return try {
            val blessings = tibia.blessings().blessingsInformation()
            logger.info("Reponse repository: ${blessings}")
            blessings
        }catch (e:Exception){
            logger.error("Error repository: ${e.message}")
            null
        }
    }
}