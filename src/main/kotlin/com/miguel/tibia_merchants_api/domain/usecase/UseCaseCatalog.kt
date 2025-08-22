package com.miguel.tibia_merchants_api.domain.usecase

import API.Tibia.models.Catalog
import com.miguel.tibia_merchants_api.data.repositories.CatalogRepository

class UseCaseCatalog(private val reposity: CatalogRepository) {
    suspend fun catalog(): ArrayList<Catalog>? {
        return reposity.catalog()
    }
}