package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.EmbuimentsRepository
import com.miguel.tibia_merchants_api.data.repositories.wikipediaapi.RepositoryWikiTibia
import com.miguel.tibia_merchants_api.domain.models.Imbuements

class UseCaseEmbuiments(private val repository: EmbuimentsRepository, private val repositoryWikiTibia: RepositoryWikiTibia) {
    suspend fun embuiment(): Imbuements? {
        val response = repositoryWikiTibia.getWikiContent("Imbuing")
        val html = response.parse?.text?.content
        return repository.getEmbuiments(html = html)
    }
}