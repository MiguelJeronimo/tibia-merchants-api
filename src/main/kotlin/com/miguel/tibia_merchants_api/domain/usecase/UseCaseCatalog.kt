package com.miguel.tibia_merchants_api.domain.usecase

import API.Tibia.models.Catalog
import com.miguel.tibia_merchants_api.data.repositories.CatalogRepository
import com.miguel.tibia_merchants_api.data.repositories.wikipediaapi.RepositoryWikiTibia

class UseCaseCatalog(private val reposity: CatalogRepository, private val repositoryWikiTibia: RepositoryWikiTibia) {
    suspend fun catalog(): ArrayList<Catalog>? {
        val response = repositoryWikiTibia.getWikiContent("Main_Page")
        val html = response.parse?.text?.content.toString()
        return reposity.catalog(html = html)
    }
}