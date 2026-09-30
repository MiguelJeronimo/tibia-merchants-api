package com.miguel.tibia_merchants_api.data.repositories.trade

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.ObjectMapper

private val tradeObjectMapper = ObjectMapper()


/**
 * Base interface for trade request parameters.
 * **/
sealed interface TradeRequestParams {
    @JsonIgnore
    fun asMap(): Map<String, Any> = emptyMap()
}


/**
 * Represents the parameters for listing trade ads.
 * **/
data class TradeAdListParams(
    val sortType: String = "3",
    val page: String = "1",
    val worldId: String? = null,
    val itemType: String? = null,
    val town: String? = null,
    val search: String? = null,
    val minLevel: String? = null,
    val maxLevel: String? = null,
    val orderBy: String? = null,
    val orderDirection: String? = null
) : TradeRequestParams {
    override fun asMap(): Map<String, Any> = buildMap {
        put("sortType", sortType)
        put("page", page)
        worldId?.let { put("worldId", it) }
        itemType?.let { put("itemType", it) }
        town?.let { put("town", it) }
        search?.let { put("search", it) }
        minLevel?.let { put("minLevel", it) }
        maxLevel?.let { put("maxLevel", it) }
        orderBy?.let { put("orderBy", it) }
        orderDirection?.let { put("orderDirection", it) }
    }
}


/**
 * Represents the input for a batch trade request.
 * **/
data class TradeBatchInput(
    val worldList: Map<String, Any> = emptyMap(),
    val houseListTowns: Map<String, Any> = emptyMap(),
    val itemListTypes: Map<String, Any> = emptyMap(),
    val adList: TradeAdListParams? = null
) : TradeRequestParams {
    override fun asMap(): Map<String, Any> = buildMap {
        if (worldList.isNotEmpty()) put("0", worldList)
        if (houseListTowns.isNotEmpty()) put("1", houseListTowns)
        if (itemListTypes.isNotEmpty()) put("2", itemListTypes)
        if (adList != null) put("3", adList.asMap())
    }

    /**
     * Converts the batch input to a JSON string.
     * @return The JSON string representing the batch input.
     */
    fun toJson(): String = tradeObjectMapper.writeValueAsString(asMap())
}
