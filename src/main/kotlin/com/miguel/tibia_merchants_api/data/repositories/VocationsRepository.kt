package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Vocation
import API.Tibia.models.Vocations

interface VocationsRepository {
    fun vocations(): ArrayList<Vocations>?
    fun sorcerer(): Vocation?
    fun druid(): Vocation?
    fun knight(): Vocation?
    fun paladin(): Vocation?
}