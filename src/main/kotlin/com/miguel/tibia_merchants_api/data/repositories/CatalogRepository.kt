package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Catalog

interface CatalogRepository {
    fun catalog(): ArrayList<Catalog>?
}