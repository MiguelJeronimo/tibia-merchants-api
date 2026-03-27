package com.miguel.tibia_merchants_api.data.repositories.wikipediaapi

import com.miguel.tibia_merchants_api.domain.models.WikiModels


interface RepositoryWikiTibia {
    suspend fun getWikiContent(title: String): WikiModels
}