package com.miguel.tibia_merchants_api.repository

import API.Tibia.models.Catalog
import Tibia.Tibia
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class RepositoryCatalog {
    private val logger: Logger = LogManager.getLogger(RepositoryCatalog::class.java)
    fun catalog(): ArrayList<Catalog>? {
        try {
            val tibia = Tibia().catalog().options()
            logger.info("Reponse repository: ${tibia}")
            return tibia
        } catch (e:Exception){
            logger.error("Error repository: ${e.message}")
            return null
        }
    }
}