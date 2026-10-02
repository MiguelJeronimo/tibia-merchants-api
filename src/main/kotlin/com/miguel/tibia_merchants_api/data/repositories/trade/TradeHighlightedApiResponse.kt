package com.miguel.tibia_merchants_api.data.repositories.trade

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeHighlightedBatchResponse(
    @JsonProperty("result") val result: TradeHighlightedBatchResult
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeHighlightedBatchResult(
    @JsonProperty("data") val data: TradeHighlightedBatchData
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeHighlightedBatchData(
    @JsonProperty("highlighted_ads") val highlightedAds: List<TradeAd>? = null,
    @JsonProperty("worlds") val worlds: List<TradeWorld>? = null,
    @JsonProperty("prices") val prices: List<TradeTibiaCoinPrice>? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeHighlightedCatalogResponse(
    var highlightedAds: List<TradeAd> = emptyList(),
    var worlds: List<TradeWorld> = emptyList(),
    var prices: List<TradeTibiaCoinPrice> = emptyList()
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeTibiaCoinPrice(
    @JsonProperty("world_name") val worldName: String? = null,
    @JsonProperty("buy_average_price") val buyAveragePrice: Number? = null,
    @JsonProperty("buy_highest_price") val buyHighestPrice: Number? = null,
    @JsonProperty("sell_lowest_price") val sellLowestPrice: Number? = null,
    @JsonProperty("sell_average_price") val sellAveragePrice: Number? = null,
    @JsonProperty("created_at") val createdAt: String? = null
)
