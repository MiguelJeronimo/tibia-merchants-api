package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Vocation
import API.Tibia.models.Vocations
import com.miguel.tibia_merchants_api.data.network.Tibia
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class VocationsRepositoryImp(private val tibia: Tibia): VocationsRepository {
    private val logger: Logger = LogManager.getLogger(VocationsRepositoryImp::class.java)

    override fun vocations(): ArrayList<Vocations>? {
        try {
            val vocation = tibia.vocations().vocationList()
            logger.info("Vocations List response: $vocation")
            return vocation
        } catch (e:Exception){
            logger.error("Error vocation: ${e.message}")
            return null
        }
    }

    override fun sorcerer(): Vocation? {
        try {
            val sorcerer = tibia.vocations().sorcerer()
            logger.info("sorcerer repository: $sorcerer")
            return sorcerer
        } catch (e:Exception){
            logger.error("Error sorcerer repository: ${e.message}")
            return null
        }
    }

    override fun druid(): Vocation? {
        try {
            val druid = tibia.vocations().druid()
            logger.info("druid repository: $druid")
            return druid
        } catch (e:Exception){
            logger.error("Error druid repository: ${e.message}")
            return null
        }
    }

    override fun knight(): Vocation? {
        try {
            val knight = tibia.vocations().knight()
            logger.info("knight repository: $knight")
            return knight
        } catch (e:Exception){
            logger.error("Error repository repository: ${e.message}")
            return null
        }
    }

    override fun paladin(): Vocation? {
        try {
            val paladin = tibia.vocations().paladin()
            logger.info("paladin repository: $paladin")
            return paladin
        } catch (e:Exception){
            logger.error("Error paladin repository: ${e.message}")
            return null
        }
    }
}