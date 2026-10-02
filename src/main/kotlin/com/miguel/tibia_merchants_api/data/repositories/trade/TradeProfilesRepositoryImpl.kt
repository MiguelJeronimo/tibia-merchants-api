package com.miguel.tibia_merchants_api.data.repositories.trade

import com.miguel.tibia_merchants_api.data.network.responses.Ad
import com.miguel.tibia_merchants_api.data.network.responses.ItemProfileParams
import com.miguel.tibia_merchants_api.data.network.responses.MarketPrice
import com.miguel.tibia_merchants_api.data.network.responses.TibiaTradeResponse
import com.miguel.tibia_merchants_api.data.network.responses.toItemsMap
import com.miguel.tibia_merchants_api.data.network.responses.toMarketMap
import com.miguel.tibia_merchants_api.utils.Constants
import com.miguel.tibia_merchants_api.utils.exceptions.ResourceNotFoundException
import kotlinx.coroutines.reactor.awaitSingle
import org.apache.logging.log4j.LogManager
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import java.net.URI
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class TradeProfilesRepositoryImpl(
    private val webClient: WebClient = WebClient.builder().build()
) : TradeProfilesRepository {
    private val logger = LogManager.getLogger(this::class.java)

    override suspend fun tradeItemProfile(params: ItemProfileParams): List<TibiaTradeResponse<Ad>> {
        val request = TradeBatchDirectInput(params.toItemsMap())
        logger.info("Request: {}", request)
        val json = request.toJson()
        val encoded = URLEncoder.encode(json, StandardCharsets.UTF_8)
        val url = "${Constants.UrlTrade.route}/ad.fetchById?batch=1&input=$encoded"
        logger.info("URL: {}", "${Constants.UrlTrade.route}/ad.fetchById?batch=1&input=$json")
        val response = webClient.get().uri(URI.create(url))
            .retrieve()
            .onStatus({ status -> !status.is2xxSuccessful }) { response ->
                response.bodyToMono<String>().map { body ->
                    throw ResourceNotFoundException("Failed to fetch trade item profile: ${response.statusCode()} - $body")
                }
            }
            .bodyToMono<List<TibiaTradeResponse<Ad>>>().awaitSingle()
        logger.info("Response: {}", response)
        return response
    }

    override suspend fun tradeTradePriceProfile(params: ItemProfileParams): List<TibiaTradeResponse<MarketPrice>> {
        val request = TradeBatchDirectInput(params.toMarketMap())
        logger.info("Request: {}", request)
        val json = request.toJson()
        logger.info("URL: {}", "${Constants.UrlTrade.route}/ad.marketPrice?batch=1&input=$json")
        val encoded = URLEncoder.encode(json, StandardCharsets.UTF_8)
        val url = "${Constants.UrlTrade.route}/ad.marketPrice?batch=1&input=$encoded"
        val response = webClient.get().uri(URI.create(url))
            .retrieve()
            .onStatus({ status -> !status.is2xxSuccessful }) { response ->
                response.bodyToMono<String>().map { body ->
                    throw ResourceNotFoundException("Failed to fetch trade market price: ${response.statusCode()} - $body")
                }
            }
            .bodyToMono<List<TibiaTradeResponse<MarketPrice>>>().awaitSingle()
        logger.info("Response: {}", response)
        return response
    }

    override suspend fun getUserPublicProfile(
        username: String,
        sortType: String,
        page: String,
        productType: String?
    ): List<TibiaTradeResponse<TradePublicProfileData>> {
        val payload = buildMap {
            put("username", username)
            put("sortType", sortType)
            put("page", page)
            productType?.takeIf { it.isNotBlank() }?.let { put("productType", it) }
        }
        val request = TradeBatchDirectInput(mapOf("0" to payload))
        logger.info("User public profile request: {}", request)
        val encoded = URLEncoder.encode(request.toJson(), StandardCharsets.UTF_8)
        logger.info("URL: {}", "${Constants.UrlTrade.route}/user.getPublicProfile?batch=1&input=${request.toJson()}")
        val url = "${Constants.UrlTrade.route}/user.getPublicProfile?batch=1&input=$encoded"
        val response = webClient.get().uri(URI.create(url))
            .retrieve()
            .onStatus({ status -> !status.is2xxSuccessful }) { response ->
                response.bodyToMono<String>().map { body ->
                    throw ResourceNotFoundException("Failed to fetch public profile: ${response.statusCode()} - $body")
                }
            }
            .bodyToMono<List<TibiaTradeResponse<TradePublicProfileData>>>().awaitSingle()
        logger.info("User public profile response: {}", response)
        return response
    }
}