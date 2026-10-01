package com.miguel.tibia_merchants_api.utils

class ImageUrl {
    companion object {
        fun getImageUrl(itemName: String): String {
            val url = Constants.UrlTradeImg.route
            val formattedName = itemName.replace(" ", "_")
            return "$url$formattedName.gif"
        }
    }
}