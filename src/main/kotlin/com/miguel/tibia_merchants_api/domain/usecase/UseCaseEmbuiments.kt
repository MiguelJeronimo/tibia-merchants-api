package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.EmbuimentsRepository
import com.miguel.tibia_merchants_api.domain.models.Imbuements

class UseCaseEmbuiments(private val repository: EmbuimentsRepository) {
    suspend fun embuiment(): Imbuements? {
        return repository.getEmbuiments()
    }
}