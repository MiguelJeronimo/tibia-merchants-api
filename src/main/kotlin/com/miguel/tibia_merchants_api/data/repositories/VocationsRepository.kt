package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Vocation
import API.Tibia.models.Vocations

interface VocationsRepository {
    suspend fun vocations(): ArrayList<Vocations>?
    suspend fun sorcerer(): Vocation?
    suspend fun druid(): Vocation?
    suspend fun knight(): Vocation?
    suspend fun paladin(): Vocation?
}