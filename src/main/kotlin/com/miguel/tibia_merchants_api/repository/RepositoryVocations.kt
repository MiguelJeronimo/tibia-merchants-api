package com.miguel.tibia_merchants_api.repository

import API.Tibia.models.Vocation
import API.Tibia.models.Vocations
import Tibia.Tibia
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class RepositoryVocations {
    private val logger: Logger = LogManager.getLogger(RepositoryVocations::class.java)
    fun vocations(): ArrayList<Vocations>? {
        try {
            val tibia = Tibia().vocations().vocationList()
            logger.info("Vocations List response: $tibia")
            return tibia
        } catch (e:Exception){
            logger.error("Error vocation: ${e.message}")
            return null
        }
    }
    fun sorcerer(): Vocation? {
        try {
            val tibia = Tibia().vocations().sorcerer()
            logger.info("sorcerer repository: $tibia")
            return tibia
        } catch (e:Exception){
            logger.error("Error sorcerer repository: ${e.message}")
            return null
        }
    }

    fun druid(): Vocation? {
        try {
            val tibia = Tibia().vocations().druid()
            logger.info("druid repository: $tibia")
            return tibia
        } catch (e:Exception){
            logger.error("Error druid repository: ${e.message}")
            return null
        }
    }

    fun knight(): Vocation? {
        try {
            val tibia = Tibia().vocations().knight()
            logger.info("knight repository: $tibia")
            return tibia
        } catch (e:Exception){
            logger.error("Error repository repository: ${e.message}")
            return null
        }
    }

    fun paladin(): Vocation? {
        try {
            val tibia = Tibia().vocations().paladin()
            logger.info("paladin repository: $tibia")
            return tibia
        } catch (e:Exception){
            logger.error("Error paladin repository: ${e.message}")
            return null
        }
    }
}