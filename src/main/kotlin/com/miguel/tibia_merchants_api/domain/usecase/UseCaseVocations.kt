package com.miguel.tibia_merchants_api.domain.usecase

import API.Tibia.models.Vocation
import API.Tibia.models.Vocations
import com.miguel.tibia_merchants_api.data.repositories.VocationsRepository

class UseCaseVocations(private val repository: VocationsRepository) {
    suspend fun vocatons(): ArrayList<Vocations>? {
        return repository.vocations()
    }

    suspend fun vocation(name: String): Vocation? {
        return when(name.lowercase()){
            "sorcerer" -> sorcerer()
            "druid" -> druid()
            "knight" -> knight()
            "paladin" -> paladin()
            else -> null
        }
    }

    private suspend fun sorcerer(): Vocation? {
        return repository.sorcerer()
    }

    private suspend fun druid(): Vocation? {
        return repository.druid()
    }

    private suspend fun knight(): Vocation? {
        return repository.knight()
    }

    private suspend fun paladin(): Vocation? {
        return repository.paladin()
    }
}