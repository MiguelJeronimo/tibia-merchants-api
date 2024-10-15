package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Catalog
import com.miguel.tibia_merchants_api.data.network.Tibia
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class CatalogRepositoryImp(private val tibia: Tibia): CatalogRepository {
    private val logger: Logger = LogManager.getLogger(CatalogRepositoryImp::class.java)
    override fun catalog(): ArrayList<Catalog>? {
        try {
            val options = tibia.catalog().options()
            logger.info("Reponse repository: ${options}")
            return options
        } catch (e:Exception){
            logger.error("Error repository: ${e.message}")
            return null
        }
    }
}