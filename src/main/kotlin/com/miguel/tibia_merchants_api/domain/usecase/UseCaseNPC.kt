package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.NPCRepository
import com.miguel.tibia_merchants_api.domain.models.npc.NPCInfo

class UseCaseNPC(private val repository: NPCRepository) {
    fun npc(name:String): Any? {
        return repository.npc(name)
    }

    fun npcInfo(name:String): NPCInfo? {
        return repository.npcInfo(name = name)
    }
}