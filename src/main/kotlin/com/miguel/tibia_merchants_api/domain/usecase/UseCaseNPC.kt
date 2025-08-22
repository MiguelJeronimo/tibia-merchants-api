package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.NPCRepository
import com.miguel.tibia_merchants_api.domain.models.npc.NPCInfo

class UseCaseNPC(private val repository: NPCRepository) {
    suspend fun npc(name:String): Any? {
        return repository.npc(name)
    }

    suspend fun npcInfo(name:String): NPCInfo? {
        return repository.npcInfo(name = name)
    }
}