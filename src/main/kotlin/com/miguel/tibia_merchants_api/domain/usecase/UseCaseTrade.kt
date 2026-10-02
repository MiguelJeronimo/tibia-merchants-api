package com.miguel.tibia_merchants_api.domain.usecase

import com.miguel.tibia_merchants_api.data.repositories.trade.TradeAdListParams
import com.miguel.tibia_merchants_api.data.repositories.trade.TradeRepository
import com.miguel.tibia_merchants_api.domain.models.trade.AllItems
import com.miguel.tibia_merchants_api.domain.models.trade.ParamsItemsDto
import com.miguel.tibia_merchants_api.domain.models.trade.TcPriceDto
import com.miguel.tibia_merchants_api.domain.models.trade.toAllItems
import com.miguel.tibia_merchants_api.domain.models.trade.toDomain
import com.miguel.tibia_merchants_api.domain.models.trade.toTradeAdListParams

class UseCaseTrade(private val repository: TradeRepository) {
    suspend fun getWorlds() = repository.getWorlds()
    suspend fun getTownNames() = repository.getTownNames()
    suspend fun getItemTypes() = repository.getItemTypes()
    suspend fun getItems(params: ParamsItemsDto): AllItems {
        val params = params.toTradeAdListParams()
        return repository.getAds(params).toAllItems()
    }
    suspend fun getCatalog(params: TradeAdListParams = TradeAdListParams()) = repository.getCatalog(params)
    suspend fun getHighlightedAds() = repository.getHighlightedAds()
    suspend fun getTibiaCoinPrices(): List<TcPriceDto> {
        return repository.getTibiaCoinPrices().toDomain()
    }
    suspend fun getTibiaCoinPrice() = repository.getTibiaCoinPrice()
    suspend fun getHighlightedCatalog() = repository.getHighlightedCatalog()
}