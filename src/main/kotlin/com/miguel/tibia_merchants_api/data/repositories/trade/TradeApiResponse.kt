package com.miguel.tibia_merchants_api.data.repositories.trade

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeBatchResponse(
    @JsonProperty("result") val result: TradeBatchResult
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeBatchResult(
    @JsonProperty("data") val data: TradeBatchData
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeBatchData(
    @JsonProperty("worlds") val worlds: List<TradeWorld>? = null,
    @JsonProperty("towns") val towns: List<String>? = null,
    @JsonProperty("item_types") val itemTypes: List<TradeItemType>? = null,
    @JsonProperty("count") val count: Int? = null,
    @JsonProperty("ads") val ads: List<TradeAd>? = null,
    @JsonProperty("highlighted_ads") val highlightedAds: List<TradeAd>? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeWorld(
    @JsonProperty("id") val id: Int? = null,
    @JsonProperty("name") val name: String? = null,
    @JsonProperty("battleye_color") val battleyeColor: String? = null,
    @JsonProperty("pvp_type") val pvpType: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeItemType(
    @JsonProperty("id") val id: Int? = null,
    @JsonProperty("name") val name: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeCatalogResponse(
    var worlds: List<TradeWorld> = emptyList(),
    var towns: List<String> = emptyList(),
    var itemTypes: List<TradeItemType> = emptyList(),
    var count: Int? = null,
    var ads: List<TradeAd> = emptyList(),
    var highlightedAds: List<TradeAd> = emptyList()
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradeAd(
    @JsonProperty("id") val id: Long? = null,
    @JsonProperty("item_amount") val itemAmount: Int? = null,
    @JsonProperty("item_id") val itemId: Int? = null,
    @JsonProperty("item_tier") val itemTier: Int? = null,
    @JsonProperty("house_id") val houseId: Long? = null,
    @JsonProperty("highlighted_until") val highlightedUntil: String? = null,
    @JsonProperty("user_id") val userId: Long? = null,
    @JsonProperty("price") val price: String? = null,
    @JsonProperty("currency_type") val currencyType: Int? = null,
    @JsonProperty("type") val type: Int? = null,
    @JsonProperty("world_id") val worldId: Int? = null,
    @JsonProperty("created_at") val createdAt: String? = null,
    @JsonProperty("is_closed") val isClosed: Int? = null,
    @JsonProperty("is_rookgaard") val isRookgaard: Boolean? = null,
    @JsonProperty("item_name") val itemName: String? = null,
    @JsonProperty("item_look") val itemLook: String? = null,
    @JsonProperty("world_name") val worldName: String? = null,
    @JsonProperty("world_pvp_type") val worldPvpType: String? = null,
    @JsonProperty("world_battleye_color") val worldBattleyeColor: String? = null,
    @JsonProperty("username") val username: String? = null,
    @JsonProperty("avatar") val avatar: String? = null,
    @JsonProperty("is_whatsapp_verified") val isWhatsappVerified: Int? = null,
    @JsonProperty("is_verified") val isVerified: Int? = null,
    @JsonProperty("house_name") val houseName: String? = null,
    @JsonProperty("town") val town: String? = null,
    @JsonProperty("tibia_id") val tibiaId: String? = null,
    @JsonProperty("size") val size: String? = null,
    @JsonProperty("rent") val rent: String? = null,
    @JsonProperty("beds") val beds: String? = null,
    @JsonProperty("floors") val floors: String? = null,
    @JsonProperty("rooms") val rooms: String? = null,
    @JsonProperty("windows") val windows: String? = null,
    @JsonProperty("coordinates") val coordinates: String? = null,
    @JsonProperty("furnitures") val furnitures: String? = null,
    @JsonProperty("is_guildhall") val isGuildhall: Boolean? = null,
    @JsonProperty("tibiablackjack_username") val tibiaBlackjackUsername: String? = null,
    @JsonProperty("is_user_verified") val isUserVerified: Boolean? = null,
    @JsonProperty("view_count") val viewCount: Int? = null,
    @JsonProperty("is_highlight_prepaid") val isHighlightPrepaid: Boolean? = null,
    @JsonProperty("auto_renew") val autoRenew: Boolean? = null,
    @JsonProperty("auto_highlight") val autoHighlight: Boolean? = null,
    @JsonProperty("tibiablackjackUsername") val tibiaBlackjackUsernameAlt: String? = null,
    @JsonProperty("converted_price") val convertedPrice: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TradePublicProfileData(
    @JsonProperty("created_at") val createdAt: String? = null,
    @JsonProperty("last_login") val lastLogin: String? = null,
    @JsonProperty("avatar") val avatar: String? = null,
    @JsonProperty("is_verified") val isVerified: Boolean? = null,
    @JsonProperty("concluded_deals_count") val concludedDealsCount: Int? = null,
    @JsonProperty("tibiablackjackUsername") val tibiaBlackjackUsername: String? = null,
    @JsonProperty("ads") val ads: List<TradeAd>? = null,
    @JsonProperty("presets") val presets: List<Any>? = null
)
