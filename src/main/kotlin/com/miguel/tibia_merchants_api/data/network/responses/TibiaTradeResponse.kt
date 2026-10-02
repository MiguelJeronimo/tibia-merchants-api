package com.miguel.tibia_merchants_api.data.network.responses

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


@JsonIgnoreProperties(ignoreUnknown = true)
data class TibiaTradeResponse<out T>(
    @JsonProperty("result") val result: TibiaTradeDataResponse<T>?,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TibiaTradeDataResponse<out T>(
    @JsonProperty("data") val data: T
)