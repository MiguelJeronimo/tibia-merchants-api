package com.miguel.tibia_merchants_api.domain.models.trade

import com.miguel.tibia_merchants_api.data.network.responses.Ad
import com.miguel.tibia_merchants_api.data.network.responses.ItemProfileParams
import com.miguel.tibia_merchants_api.data.network.responses.MarketPrice
import com.miguel.tibia_merchants_api.data.network.responses.TibiaTradeResponse
import com.miguel.tibia_merchants_api.data.repositories.trade.TradePublicProfileData
import com.miguel.tibia_merchants_api.utils.ImageUrl

data class TradeProfileParamDto(
    val id:Long? = null,
    val itemId: Long? = null,
    val itemTear: Int? = null,
    val currencyType: Int? = null,
    val type: Int? = null
)

fun TradeProfileParamDto.toParams(): ItemProfileParams {
    return ItemProfileParams(
        id = this.id,
        itemId = this.itemId,
        itemTear = this.itemTear,
        currencyType = this.currencyType,
        type = this.type
    )
}

//dtos Ad Response
data class AddDto(
    val info: InfoAdDto? = null,                          // ⚠️ confirma el nombre de la llave
    var marketPrice: MarketPriceDto? = null,    // ⚠️ confirma nombre y ubicación
    val isClosed: Boolean = false,
    val isActive: Boolean = false,
    val hasFeedImage: Boolean = false,
    val hasStoryImage: Boolean = false,
    val hasFeedPtBrImage: Boolean = false,
    val hasStoryPtBrImage: Boolean = false,
    val screenshotCount: Int? = null
)

data class InfoAdDto(
    val id: Long? = null,
    val itemName: String? = null,
    val imageUrl: String? = null,
    val itemAmount: Int? = null,
    val itemId: Int? = null,
    val tibiaId: Int? = null,
    val houseId: Long? = null,
    val itemTier: Int? = null,
    val itemLook: String? = null,
    val username: String? = null,
    val userId: Long? = null,
    val price: Long? = null,
    val currencyType: Int? = null,
    val roomsImages: List<String>? = null,
    val type: Int? = null,
    val worldId: Int? = null,
    val worldName: String? = null,
    val worldPvpType: String? = null,
    val worldBattleyeColor: String? = null,
    val createdAt: String? = null,
    val isClosed: Int? = null,     // viene como 0/1 (Int), por eso sí es nullable
    val isRookgaard: Boolean,
    val isUserVerified: Boolean,
    val isHighlightPrepaid: Boolean,
    val viewCount: Int? = null,
    val autoRenew: Boolean,
    val autoHighlight: Boolean,
    val isGuildhall: Boolean,
    val town: String? = null,
    val size: Int? = null,
    val rooms: Int? = null,
    val beds: Int? = null,
    val floors: Int? = null,
    val rent: Long? = null,
    val windows: Int? = null,
    val furnitures: String? = null,
    val coordinates: String? = null,
    val convertedPrice: Long? = null,
    val avatar: String? = null,
    val tibiaBlackjackUsername: String? = null
)

data class MarketPriceDto(
    val referencePrice: Long? = null,
    val sampleSize: Int? = null,
    val source: String? = null
)

data class UserPublicProfileDto(
    val createdAt: String? = null,
    val lastLogin: String? = null,
    val avatar: String? = null,
    val isVerified: Boolean? = null,
    val concludedDealsCount: Int? = null,
    val tibiaBlackjackUsername: String? = null,
    val ads: List<ItemsDto> = emptyList(),
    val presets: List<Any> = emptyList()
)

fun List<TibiaTradeResponse<TradePublicProfileData>>.toUserProfileDto(): UserPublicProfileDto {
    val profile = this.firstOrNull()?.result?.data ?: return UserPublicProfileDto()
    return UserPublicProfileDto(
        createdAt = profile.createdAt,
        lastLogin = profile.lastLogin,
        avatar = profile.avatar,
        isVerified = profile.isVerified,
        concludedDealsCount = profile.concludedDealsCount,
        tibiaBlackjackUsername = profile.tibiaBlackjackUsername,
        ads = profile.ads?.map { ad ->
            ItemsDto(
                id = ad.id,
                itemAmount = ad.itemAmount,
                itemId = ad.itemId,
                itemTier = ad.itemTier,
                houseId = ad.houseId,
                highlightedUntil = ad.highlightedUntil,
                userId = ad.userId,
                price = ad.price,
                currencyType = ad.currencyType,
                type = ad.type,
                worldId = ad.worldId,
                createdAt = ad.createdAt,
                isClosed = ad.isClosed,
                isRookgaard = ad.isRookgaard,
                itemName = ad.itemName,
                itemLook = ad.itemLook,
                worldName = ad.worldName,
                worldPvpType = ad.worldPvpType,
                worldBattleyeColor = ad.worldBattleyeColor,
                username = ad.username,
                avatar = ad.avatar,
                isWhatsappVerified = ad.isWhatsappVerified,
                isVerified = ad.isVerified,
                houseName = ad.houseName,
                town = ad.town,
                tibiaId = ad.tibiaId,
                size = ad.size,
                rent = ad.rent,
                beds = ad.beds,
                floors = ad.floors,
                rooms = ad.rooms,
                windows = ad.windows,
                coordinates = ad.coordinates,
                furnitures = ad.furnitures,
                isGuildhall = ad.isGuildhall,
                tibiaBlackjackUsername = ad.tibiaBlackjackUsername,
                isUserVerified = ad.isUserVerified,
                viewCount = ad.viewCount,
                isHighlightPrepaid = ad.isHighlightPrepaid,
                autoRenew = ad.autoRenew,
                autoHighlight = ad.autoHighlight,
                tibiaBlackjackUsernameAlt = ad.tibiaBlackjackUsernameAlt,
                convertedPrice = ad.convertedPrice
            )
        } ?: emptyList(),
        presets = profile.presets ?: emptyList()
    )
}

fun List<TibiaTradeResponse<Ad>>.toDomain(): AddDto {
    val screenshotCount = this[0].result?.data?.screenshotCount
    val tibiaId = this[0].result?.data?.info?.tibiaId
    val roomImages = ImageUrl.screenshotUrl(screenshotCount = screenshotCount?:0, tibiaId = tibiaId?:0)

    val info = InfoAdDto(
        id = this[0].result?.data?.info?.id,
        itemName = this[0].result?.data?.info?.itemName,
        imageUrl = ImageUrl.getImageUrl(
            itemName = this[0].result?.data?.info?.itemName,
            tibiaId = this[0].result?.data?.info?.tibiaId
        ),
        itemAmount = this[0].result?.data?.info?.itemAmount,
        itemId = this[0].result?.data?.info?.itemId,
        tibiaId = this[0].result?.data?.info?.tibiaId,
        houseId = this[0].result?.data?.info?.houseId,
        itemTier = this[0].result?.data?.info?.itemTier,
        itemLook = this[0].result?.data?.info?.itemLook,
        username = this[0].result?.data?.info?.username,
        userId = this[0].result?.data?.info?.userId,
        price = this[0].result?.data?.info?.price,
        currencyType = this[0].result?.data?.info?.currencyType,
        type = this[0].result?.data?.info?.type,
        worldId = this[0].result?.data?.info?.worldId,
        worldName = this[0].result?.data?.info?.worldName,
        roomsImages = roomImages,
        worldPvpType = this[0].result?.data?.info?.worldPvpType,
        worldBattleyeColor = this[0].result?.data?.info?.worldBattleyeColor,
        createdAt = this[0].result?.data?.info?.createdAt,
        isClosed = this[0].result?.data?.info?.isClosed,
        isRookgaard = this[0].result?.data?.info?.isRookgaard ?: false,
        isUserVerified = this[0].result?.data?.info?.isUserVerified ?: false,
        isHighlightPrepaid = this[0].result?.data?.info?.isHighlightPrepaid ?: false,
        viewCount = this[0].result?.data?.info?.viewCount,
        autoRenew = this[0].result?.data?.info?.autoRenew ?: false,
        autoHighlight = this[0].result?.data?.info?.autoHighlight ?: false,
        isGuildhall = this[0].result?.data?.info?.isGuildhall ?: false,
        town = this[0].result?.data?.info?.town,
        size = this[0].result?.data?.info?.size,
        rooms = this[0].result?.data?.info?.rooms,
        beds = this[0].result?.data?.info?.beds,
        floors = this[0].result?.data?.info?.floors,
        rent = this[0].result?.data?.info?.rent,
        windows = this[0].result?.data?.info?.windows,
        furnitures = this[0].result?.data?.info?.furnitures,
        coordinates = this[0].result?.data?.info?.coordinates,
        convertedPrice = this[0].result?.data?.info?.convertedPrice,
        avatar = this[0].result?.data?.info?.avatar,
        tibiaBlackjackUsername = this[0].result?.data?.info?.tibiaBlackjackUsername
    )
    return AddDto(
        info = info,
        isClosed = this[0].result?.data?.info?.isClosed == 1,
        isActive = this[0].result?.data?.info?.isClosed == 0,
        hasFeedImage = this[0].result?.data?.hasFeedImage ?: false,
        screenshotCount = this[0].result?.data?.screenshotCount,
        hasStoryImage = this[0].result?.data?.hasStoryImage ?: false,
        hasFeedPtBrImage = this[0].result?.data?.hasFeedPtBrImage ?: false,
        hasStoryPtBrImage = this[0].result?.data?.hasStoryPtBrImage ?: false
    )
}

fun List<TibiaTradeResponse<MarketPrice>>.toMarketPrice(): MarketPriceDto {
    val market = this[0].result?.data?: return MarketPriceDto()
    val marketPrice = MarketPriceDto(
        referencePrice = market.referencePrice,
        sampleSize = market.sampleSize,
        source = market.source
    )
    return marketPrice
}