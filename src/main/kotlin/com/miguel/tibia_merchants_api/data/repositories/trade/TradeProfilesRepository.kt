package com.miguel.tibia_merchants_api.data.repositories.trade

import com.miguel.tibia_merchants_api.data.network.responses.Ad
import com.miguel.tibia_merchants_api.data.network.responses.ItemProfileParams
import com.miguel.tibia_merchants_api.data.network.responses.MarketPrice
import com.miguel.tibia_merchants_api.data.network.responses.TibiaTradeResponse

interface TradeProfilesRepository {
    suspend fun tradeItemProfile(params: ItemProfileParams):  List<TibiaTradeResponse<Ad>>
    suspend fun tradeTradePriceProfile(params: ItemProfileParams): List<TibiaTradeResponse<MarketPrice>>
    suspend fun getUserPublicProfile(
        username: String,
        sortType: String = "3",
        page: String = "1",
        productType: String? = null
    ): List<TibiaTradeResponse<TradePublicProfileData>>
}