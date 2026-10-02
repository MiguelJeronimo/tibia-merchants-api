package com.miguel.tibia_merchants_api.utils

class ImageUrl {
    companion object {
        fun getImageUrl(itemName: String? = null, houseId:String? = null): String {
            val url = Constants.UrlTradeImg.route
            val urlHouse = Constants.UrlTradeHouseImg.route
            if (itemName == null) {
                return "$urlHouse$houseId"
            }
            val formattedName = itemName.replace(" ", "_")
            return "$url$formattedName.gif"
        }
    }
}