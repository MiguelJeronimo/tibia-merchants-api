package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.SpellsRepository
import com.miguel.tibia_merchants_api.data.repositories.wikipediaapi.RepositoryWikiTibia
import com.miguel.tibia_merchants_api.domain.models.spells.Spells

class UseCaseSpells(private val repository: SpellsRepository, private val repositoryWikiTibia: RepositoryWikiTibia) {
    suspend fun spells(): Spells? {
        val response = repositoryWikiTibia.getWikiContent("Spells")
        val html = response.parse?.text?.content.toString()
        return repository.spells(html = html)
    }
}