package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.BlessingsRepository
import com.miguel.tibia_merchants_api.data.repositories.wikipediaapi.RepositoryWikiTibia
import com.miguel.tibia_merchants_api.domain.models.Blessing

class UseCaseBlessings(private val repository: BlessingsRepository, private val repositoryWikiTibia: RepositoryWikiTibia) {
    suspend fun blessings(): Blessing? {
        val response = repositoryWikiTibia.getWikiContent("Blessings")
        val html = response.parse?.text?.content.toString()
        return repository.blessings(html)
    }
}