package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.SpellsRepository
import com.miguel.tibia_merchants_api.domain.models.spells.Spells

class UseCaseSpells(private val repository: SpellsRepository) {
    suspend fun invokeSpells(): Spells? {
        return repository.spells()
    }
}