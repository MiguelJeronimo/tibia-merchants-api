package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.BlessingsRepository
import com.miguel.tibia_merchants_api.domain.models.Blessing

class UseCaseBlessings(private val repository: BlessingsRepository) {
    fun blessings(): Blessing? {
        return repository.blessings()
    }

}