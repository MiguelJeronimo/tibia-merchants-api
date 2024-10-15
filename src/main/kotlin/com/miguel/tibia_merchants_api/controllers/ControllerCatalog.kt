package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.data.repositories.CatalogRepositoryImp
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseCatalog
import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.Response
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ControllerCatalog {
    private val logger: Logger = LogManager.getLogger(ControllerCatalog::class.java)
    @GetMapping("api/v1/catalog")
    fun catalog(): Any {
        return try {
            logger.info("init petition")
            val repositoryImp = CatalogRepositoryImp(Tibia())
            val useCaseCatalog = UseCaseCatalog(repositoryImp)
            val catalog = useCaseCatalog.catalog()
            if (catalog != null){
                val response = Response(200, catalog)
                logger.info("Response final: $response")
                ResponseEntity.ok().body(response)
            }else{
                val error = Errors(400, "Error getting catalog list")
                logger.error("Error: $error")
                ResponseEntity.badRequest().body(error)
            }
        }catch (e: Exception){
            logger.fatal("Error: ${e.message}")
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }

}