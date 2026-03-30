package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Catalog

interface CatalogRepository {
    suspend fun catalog(html: String): ArrayList<Catalog>?
}