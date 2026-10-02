package com.miguel.tibia_merchants_api.data.repositories.trade

import com.fasterxml.jackson.databind.ObjectMapper

//Filter: input
data class TradeBatchDirectInput(
    val values: Map<String, Any> = emptyMap()
) {
    fun toJson(): String = ObjectMapper().writeValueAsString(values)
}