package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.NPCRepository

class UseCaseNPC(private val repository: NPCRepository) {
    fun npc(name:String): Any? {
        return repository.npc(name)
    }
}