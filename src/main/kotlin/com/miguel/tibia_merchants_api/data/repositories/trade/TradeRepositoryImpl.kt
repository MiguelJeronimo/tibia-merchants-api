package com.miguel.tibia_merchants_api.data.repositories.trade

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

class TradeRepositoryImpl(
    private val webClient: WebClient = WebClient.builder().baseUrl("https://tibiatrade.gg").build()
) : TradeRepository {

    override suspend fun getCatalog(params: TradeAdListParams): TradeCatalogResponse {
        val request = TradeBatchInput(adList = params)

        val response = webClient.get().uri { uriBuilder ->
            uriBuilder.path("/trpc/world.list,house.listTowns,item.listTypes,ad.list")
            uriBuilder.queryParam("batch", "1")
            uriBuilder.queryParam("input", request.toJson())
            uriBuilder.build()
        }.retrieve().bodyToMono<List<TradeBatchResponse>>().awaitSingle()

        return response.fold(TradeCatalogResponse()) { acc, batchResponse ->
            val data = batchResponse.result.data
            val next = acc.copy()
            data.worlds?.let { next.worlds = it }
            data.towns?.let { next.towns = it }
            data.itemTypes?.let { next.itemTypes = it }
            data.count?.let { next.count = it }
            data.ads?.let { next.ads = it }
            data.highlightedAds?.let { next.highlightedAds = it }
            next
        }
    }

    override suspend fun getWorlds(): List<TradeWorld> {
        return getCatalog().worlds
    }

    override suspend fun getTownNames(): List<String> {
        return getCatalog().towns
    }

    override suspend fun getItemTypes(): List<TradeItemType> {
        return getCatalog().itemTypes
    }

    override suspend fun getAds(params: TradeAdListParams): TradeCatalogResponse {
        return getCatalog(params)
    }

    //Tibia CoinPrice
    override suspend fun getHighlightedCatalog(): TradeHighlightedCatalogResponse {
        val request = TradeBatchInput()

        val response = webClient.get().uri { uriBuilder ->
                uriBuilder.path("/trpc/ad.listHighlighted,world.list,tibiaCoinPrice.list")
                uriBuilder.queryParam("batch", "1")
                uriBuilder.queryParam("input", request.toJson())
                uriBuilder.build()
            }.retrieve().bodyToMono<List<TradeHighlightedBatchResponse>>().awaitSingle()

        return response.fold(TradeHighlightedCatalogResponse()) { acc, batchResponse ->
                val data = batchResponse.result.data
                val next = acc.copy()
                data.highlightedAds?.let { next.highlightedAds = it }
                data.worlds?.let { next.worlds = it }
                data.prices?.let { next.prices = it }
                next
            }
    }


    override suspend fun getHighlightedAds(): List<TradeAd> {
        return getHighlightedCatalog().highlightedAds
    }

    override suspend fun getTibiaCoinPrices(): List<TradeTibiaCoinPrice> {
        return getHighlightedCatalog().prices
    }


    private fun TradeCatalogResponse.copy(): TradeCatalogResponse {
        return TradeCatalogResponse(
            worlds = this.worlds,
            towns = this.towns,
            itemTypes = this.itemTypes,
            count = this.count,
            ads = this.ads,
            highlightedAds = this.highlightedAds
        )
    }

    private fun TradeHighlightedCatalogResponse.copy(): TradeHighlightedCatalogResponse {
        return TradeHighlightedCatalogResponse(
            highlightedAds = this.highlightedAds,
            worlds = this.worlds,
            prices = this.prices
        )
    }

}
