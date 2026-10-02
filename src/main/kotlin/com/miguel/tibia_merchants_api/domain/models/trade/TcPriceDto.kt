package com.miguel.tibia_merchants_api.domain.models.trade

import com.miguel.tibia_merchants_api.data.repositories.trade.TradeTibiaCoinPrice

data class TcPriceDto(
    val worldName: String? = null,
    val buyAveragePrice: Number? = null,
    val buyHighestPrice: Number? = null,
    val sellLowestPrice: Number? = null,
    val sellAveragePrice: Number? = null,
    val createdAt: String? = null
)

fun List<TradeTibiaCoinPrice>.toDomain(): List<TcPriceDto> {
    return this.map {
        TcPriceDto(
            worldName = it.worldName,
            buyAveragePrice = it.buyAveragePrice,
            buyHighestPrice = it.buyHighestPrice,
            sellLowestPrice = it.sellLowestPrice,
            sellAveragePrice = it.sellAveragePrice,
            createdAt = it.createdAt
        )
    }
}