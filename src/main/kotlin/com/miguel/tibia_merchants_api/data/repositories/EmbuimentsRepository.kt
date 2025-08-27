package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.data.network.tibia.EmbuimentsTibia
import com.miguel.tibia_merchants_api.domain.models.Imbuements

interface EmbuimentsRepository {
    suspend fun getEmbuiments():Imbuements?
}