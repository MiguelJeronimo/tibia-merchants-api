package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.domain.models.spells.Spells

interface SpellsRepository {
    fun spells(): Spells?
}