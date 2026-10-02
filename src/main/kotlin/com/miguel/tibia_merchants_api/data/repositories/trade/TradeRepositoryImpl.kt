package com.miguel.tibia_merchants_api.data.repositories.trade

import com.miguel.tibia_merchants_api.utils.Constants
import com.miguel.tibia_merchants_api.utils.exceptions.ResourceNotFoundException
import kotlinx.coroutines.reactor.awaitSingle
import org.apache.logging.log4j.LogManager
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import java.net.URI
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class TradeRepositoryImpl(
    private val webClient: WebClient = WebClient.builder().build()
) : TradeRepository {

    private val logger = LogManager.getLogger(TradeRepositoryImpl::class.java)
    /*
    * Fetches the catalog of trade items based on the provided parameters.
    */
    override suspend fun getCatalog(params: TradeAdListParams): TradeCatalogResponse {
        val request = TradeBatchInput(adList = params)
        return try {
            val encodedInput = URLEncoder.encode(request.toJson(), StandardCharsets.UTF_8)
            logger.info("INPUSTS: $request")
            logger.info("url: ${Constants.UrlTrade.route}/world.list,house.listTowns,item.listTypes,ad.list?batch=1&input=${request.toJson()}")
            val url = "${Constants.UrlTrade.route}/world.list,house.listTowns,item.listTypes,ad.list?batch=1&input=$encodedInput"
            val response = webClient.get()
                .uri(URI.create(url))
                .retrieve()
                .bodyToMono<List<TradeBatchResponse>>()
                .awaitSingle()
            logger.info("Trade info: $response")
            response.fold(TradeCatalogResponse()) { acc, batchResponse ->
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
        } catch (e: Exception) {
            throw ResourceNotFoundException("Failed to fetch catalog: ${e.message}", e)
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
        return try {
            val encodedInput = URLEncoder.encode(request.toJson(), StandardCharsets.UTF_8)
            logger.info("url: ${Constants.UrlTrade.route}/ad.listHighlighted,world.list,tibiaCoinPrice.list?batch=1&input=${request.toJson()}")
            val url = "${Constants.UrlTrade.route}/ad.listHighlighted,world.list,tibiaCoinPrice.list?batch=1&input=$encodedInput"
            val response = webClient.get()
                .uri(URI.create(url))
                .retrieve()
                .bodyToMono<List<TradeHighlightedBatchResponse>>()
                .awaitSingle()
            logger.info("Trade info tcPrice")
            response.fold(TradeHighlightedCatalogResponse()) { acc, batchResponse ->
                val data = batchResponse.result.data
                val next = acc.copy()
                data.highlightedAds?.let { next.highlightedAds = it }
                data.worlds?.let { next.worlds = it }
                data.prices?.let { next.prices = it }
                next
            }
        } catch (e: Exception) {
            logger.error("Failed to fetch catalog: ${e.message}", e)
            throw ResourceNotFoundException("Failed to fetch highlighted catalog: ${e.message}", e)
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
