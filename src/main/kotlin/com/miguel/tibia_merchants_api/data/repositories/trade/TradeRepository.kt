package com.miguel.tibia_merchants_api.data.repositories.trade

interface TradeRepository {
    suspend fun getWorlds(): List<TradeWorld>
    suspend fun getTownNames(): List<String>
    suspend fun getItemTypes(): List<TradeItemType>
    suspend fun getAds(params: TradeAdListParams = TradeAdListParams()): TradeCatalogResponse
    suspend fun getCatalog(params: TradeAdListParams = TradeAdListParams()): TradeCatalogResponse

    suspend fun getHighlightedAds(): List<TradeAd>
    suspend fun getTibiaCoinPrices(): List<TradeTibiaCoinPrice>
    suspend fun getTibiaCoinPrice(): TradeTibiaCoinPrice? = getTibiaCoinPrices().firstOrNull()
    suspend fun getHighlightedCatalog(): TradeHighlightedCatalogResponse
}
