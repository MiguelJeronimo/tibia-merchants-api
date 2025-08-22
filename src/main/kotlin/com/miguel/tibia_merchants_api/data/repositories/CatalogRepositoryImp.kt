package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Catalog
import com.miguel.tibia_merchants_api.data.network.Tibia
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class CatalogRepositoryImp(private val tibia: Tibia): CatalogRepository {
    private val logger: Logger = LogManager.getLogger(CatalogRepositoryImp::class.java)
    override suspend fun catalog(): ArrayList<Catalog>? {
        return try {
            withContext(Dispatchers.IO){
                val options = tibia.catalog().options()
                logger.info("Reponse repository: ${options}")
                options
            }
        } catch (e:Exception){
            logger.error("Error repository: ${e.message}")
            null
        }
    }
}