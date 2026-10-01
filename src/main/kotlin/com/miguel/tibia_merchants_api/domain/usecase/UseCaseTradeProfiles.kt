package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.trade.TradeProfilesRepository
import com.miguel.tibia_merchants_api.domain.models.trade.AddDto
import com.miguel.tibia_merchants_api.domain.models.trade.TradeProfileParamDto
import com.miguel.tibia_merchants_api.domain.models.trade.toDomain
import com.miguel.tibia_merchants_api.domain.models.trade.toMarketPrice
import com.miguel.tibia_merchants_api.domain.models.trade.toParams

class UseCaseTradeProfiles(private val repository: TradeProfilesRepository) {
    suspend fun itemProfile(params: TradeProfileParamDto): AddDto {
        val itemProfileResponse =  repository.tradeItemProfile(params = params.toParams()).toDomain()
        val tradePriceProfileResponse = repository.tradeTradePriceProfile(params = params.toParams()).toMarketPrice()
        itemProfileResponse.marketPrice = tradePriceProfileResponse
        return itemProfileResponse
    }
}