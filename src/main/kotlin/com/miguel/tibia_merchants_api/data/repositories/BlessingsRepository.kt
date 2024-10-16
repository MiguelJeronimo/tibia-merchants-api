package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.domain.models.Blessing


interface BlessingsRepository {
    fun blessings(): Blessing?
}