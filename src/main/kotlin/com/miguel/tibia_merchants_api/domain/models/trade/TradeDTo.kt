package com.miguel.tibia_merchants_api.domain.models.trade

import com.miguel.tibia_merchants_api.data.repositories.trade.TradeAdListParams
import com.miguel.tibia_merchants_api.data.repositories.trade.TradeCatalogResponse
import com.miguel.tibia_merchants_api.utils.ImageUrl


data class ParamsItemsDto(
    val sortType: String? = null,
    val page: String? = null,
    val productType: String? = null
)
data class AllItems(
    val items: List<ItemsDto>,
    val highlighted: List<ItemsDto>,
    val count: Int
)

data class ItemsDto(
    val id: Long? = null,
    val itemAmount: Int? = null,
    val itemId: Int? = null,
    val itemTier: Int? = null,
    val houseId: Long? = null,
    val highlightedUntil: String? = null,
    val userId: Long? = null,
    val price: String? = null,
    val currencyType: Int? = null,
    val type: Int? = null,
    val worldId: Int? = null,
    val createdAt: String? = null,
    val isClosed: Int? = null,
    val isRookgaard: Boolean? = null,
    val itemName: String? = null,
    val itemLook: String? = null,
    val worldName: String? = null,
    val worldPvpType: String? = null,
    val worldBattleyeColor: String? = null,
    val username: String? = null,
    val imageUrl: String? = null,
    val avatar: String? = null,
    val isWhatsappVerified: Int? = null,
    val isVerified: Int? = null,
    val houseName: String? = null,
    val town: String? = null,
    val tibiaId: Int? = null,
    val size: String? = null,
    val rent: String? = null,
    val beds: String? = null,
    val floors: String? = null,
    val rooms: String? = null,
    val windows: String? = null,
    val coordinates: String? = null,
    val furnitures: String? = null,
    val isGuildhall: Boolean? = null,
    val tibiaBlackjackUsername: String? = null,
    val isUserVerified: Boolean? = null,
    val viewCount: Int? = null,
    val isHighlightPrepaid: Boolean? = null,
    val autoRenew: Boolean? = null,
    val autoHighlight: Boolean? = null,
    val tibiaBlackjackUsernameAlt: String? = null,
    val convertedPrice: String? = null
)

fun TradeCatalogResponse.toAllItems(): AllItems {
    return AllItems(
        items = this.toTradeItems(),
        highlighted = this.toHighLightedItems(),
        count = this.count?:0
    )
}

private fun TradeCatalogResponse.toTradeItems(): List<ItemsDto> {
    val items = this.ads
    return items.map { item ->
        ItemsDto(
            id = item.id,
            itemAmount = item.itemAmount,
            itemId = item.itemId,
            itemTier = item.itemTier,
            houseId = item.houseId,
            highlightedUntil = item.highlightedUntil,
            userId = item.userId,
            price = item.price,
            currencyType = item.currencyType,
            imageUrl = ImageUrl.getImageUrl(
                itemName = item.itemName,
                tibiaId = item.tibiaId
            ),
            type = item.type,
            worldId = item.worldId,
            createdAt = item.createdAt,
            isClosed = item.isClosed,
            isRookgaard = item.isRookgaard,
            itemName = item.itemName,
            itemLook = item.itemLook,
            worldName = item.worldName,
            worldPvpType = item.worldPvpType,
            worldBattleyeColor = item.worldBattleyeColor,
            username = item.username,
            avatar = item.avatar,
            isWhatsappVerified = item.isWhatsappVerified,
            isVerified = item.isVerified,
            houseName = item.houseName,
            town = item.town,
            tibiaId = item.tibiaId,
            size = item.size,
            rent = item.rent,
            beds = item.beds,
            floors = item.floors,
            rooms = item.rooms,
            windows = item.windows,
            coordinates = item.coordinates,
            furnitures = item.furnitures,
            isGuildhall = item.isGuildhall,
            tibiaBlackjackUsername = item.tibiaBlackjackUsername,
            isUserVerified = item.isUserVerified,
            viewCount = item.viewCount,
            isHighlightPrepaid = item.isHighlightPrepaid,
            autoRenew = item.autoRenew,
            autoHighlight = item.autoHighlight,
            tibiaBlackjackUsernameAlt = item.tibiaBlackjackUsernameAlt,
            convertedPrice = item.convertedPrice
        )
    }
}

private fun TradeCatalogResponse.toHighLightedItems(): List<ItemsDto> {
    val highlightedItems = this.highlightedAds
    return highlightedItems.map { item ->
        ItemsDto(
            id = item.id,
            itemAmount = item.itemAmount,
            itemId = item.itemId,
            itemTier = item.itemTier,
            houseId = item.houseId,
            highlightedUntil = item.highlightedUntil,
            userId = item.userId,
            price = item.price,
            currencyType = item.currencyType,
            type = item.type,
            worldId = item.worldId,
            createdAt = item.createdAt,
            isClosed = item.isClosed,
            isRookgaard = item.isRookgaard,
            itemName = item.itemName,
            itemLook = item.itemLook,
            worldName = item.worldName,
            worldPvpType = item.worldPvpType,
            worldBattleyeColor = item.worldBattleyeColor,
            username = item.username,
            avatar = item.avatar,
            isWhatsappVerified = item.isWhatsappVerified,
            isVerified = item.isVerified,
            houseName = item.houseName,
            town = item.town,
            tibiaId = item.tibiaId,
            size = item.size,
            rent = item.rent,
            beds = item.beds,
            floors = item.floors,
            rooms = item.rooms,
            windows = item.windows,
            coordinates = item.coordinates,
            furnitures = item.furnitures,
            isGuildhall = item.isGuildhall,
            tibiaBlackjackUsername = item.tibiaBlackjackUsername,
            isUserVerified = item.isUserVerified,
            viewCount = item.viewCount,
            isHighlightPrepaid = item.isHighlightPrepaid,
            autoRenew = item.autoRenew,
            autoHighlight = item.autoHighlight,
            tibiaBlackjackUsernameAlt = item.tibiaBlackjackUsernameAlt,
            convertedPrice = item.convertedPrice
        )
    }
}


fun ParamsItemsDto.toTradeAdListParams(): TradeAdListParams {
    return TradeAdListParams(
        sortType = this.sortType ?: "3",
        page = this.page ?: "1",
        productType = this.productType
    )
}
