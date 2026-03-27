package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.NPCRepository
import com.miguel.tibia_merchants_api.data.repositories.wikipediaapi.RepositoryWikiTibia
import com.miguel.tibia_merchants_api.domain.models.npc.NPCInfo

class UseCaseNPC(private val repository: NPCRepository, private val repositoryWikiTibia: RepositoryWikiTibia) {
    suspend fun npc(name:String): Any? {
        return repository.npc(name)
    }

    suspend fun npcInfo(name:String): NPCInfo? {
        val response = repositoryWikiTibia.getWikiContent(name)
        val html = response.parse?.text?.content.toString()
        return repository.npcInfo(name = name, html = html)
    }
}