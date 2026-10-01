package com.miguel.tibia_merchants_api.data.network.responses

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Ad(
    @JsonProperty("ad") val info: InfoAd? = null,                          // ⚠️ confirma el nombre de la llave
    @JsonProperty("market_price") val marketPrice: MarketPrice? = null,    // ⚠️ confirma nombre y ubicación
    @JsonProperty("is_closed") val isClosed: Boolean,
    @JsonProperty("is_active") val isActive: Boolean,
    @JsonProperty("has_feed_image") val hasFeedImage: Boolean,
    @JsonProperty("has_story_image") val hasStoryImage: Boolean,
    @JsonProperty("has_feed_pt_br_image") val hasFeedPtBrImage: Boolean,
    @JsonProperty("has_story_pt_br_image") val hasStoryPtBrImage: Boolean
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoAd(
    @JsonProperty("id") val id: Long? = null,
    @JsonProperty("item_name") val itemName: String? = null,
    @JsonProperty("item_amount") val itemAmount: Int? = null,
    @JsonProperty("item_id") val itemId: Int? = null,
    @JsonProperty("house_id") val houseId: Long? = null,
    @JsonProperty("item_tier") val itemTier: Int? = null,
    @JsonProperty("item_look") val itemLook: String? = null,
    @JsonProperty("username") val username: String? = null,
    @JsonProperty("user_id") val userId: Long? = null,
    @JsonProperty("price") val price: Long? = null,
    @JsonProperty("currency_type") val currencyType: Int? = null,
    @JsonProperty("type") val type: Int? = null,
    @JsonProperty("world_id") val worldId: Int? = null,
    @JsonProperty("world_name") val worldName: String? = null,
    @JsonProperty("world_pvp_type") val worldPvpType: String? = null,
    @JsonProperty("world_battleye_color") val worldBattleyeColor: String? = null,
    @JsonProperty("created_at") val createdAt: String? = null,
    @JsonProperty("is_closed") val isClosed: Int? = null,     // viene como 0/1 (Int), por eso sí es nullable
    @JsonProperty("is_rookgaard") val isRookgaard: Boolean,
    @JsonProperty("is_user_verified") val isUserVerified: Boolean,
    @JsonProperty("is_highlight_prepaid") val isHighlightPrepaid: Boolean,
    @JsonProperty("view_count") val viewCount: Int? = null,
    @JsonProperty("auto_renew") val autoRenew: Boolean,
    @JsonProperty("auto_highlight") val autoHighlight: Boolean,
    @JsonProperty("is_guildhall") val isGuildhall: Boolean,
    @JsonProperty("converted_price") val convertedPrice: Long? = null,
    @JsonProperty("avatar") val avatar: String? = null,
    @JsonProperty("tibiablackjackUsername") val tibiaBlackjackUsername: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class MarketPrice(
    @JsonProperty("reference_price") val referencePrice: Long? = null,
    @JsonProperty("sample_size") val sampleSize: Int? = null,
    @JsonProperty("source") val source: String? = null
)

//Params
data class ItemProfileParams(
    val id:Long? = null,
    val itemId: Long? = null,
    val itemTear: Int? = null,
    val currencyType: Int? = null,
    val type: Int? = null
)

fun ItemProfileParams.toItemsMap(): Map<String, Any> {
    return  mapOf(
        "0" to mapOf("id" to this.id),
    )
}

fun ItemProfileParams.toMarketMap(): Map<String, Any> {
    return  mapOf(
        "0" to mapOf(
            "itemId" to this.itemId,
            "itemTier" to this.itemTear,
            "currencyType" to this.currencyType,
            "type" to this.type
        )
    )
}


