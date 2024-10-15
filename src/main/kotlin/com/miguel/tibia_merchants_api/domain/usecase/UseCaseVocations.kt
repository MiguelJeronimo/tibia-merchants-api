package com.miguel.tibia_merchants_api.domain.usecase

import API.Tibia.models.Vocation
import API.Tibia.models.Vocations
import com.miguel.tibia_merchants_api.data.repositories.VocationsRepository

class UseCaseVocations(private val repository: VocationsRepository) {
    fun vocatons(): ArrayList<Vocations>? {
        return repository.vocations()
    }

    fun vocation(name: String): Vocation? {
        return when(name.lowercase()){
            "sorcerer" -> sorcerer()
            "druid" -> druid()
            "knight" -> knight()
            "paladin" -> paladin()
            else -> null
        }
    }

    private fun sorcerer(): Vocation? {
        return repository.sorcerer()
    }

    private fun druid(): Vocation? {
        return repository.druid()
    }

    private fun knight(): Vocation? {
        return repository.knight()
    }

    private fun paladin(): Vocation? {
        return repository.paladin()
    }
}