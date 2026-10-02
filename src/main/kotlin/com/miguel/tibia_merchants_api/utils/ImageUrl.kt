package com.miguel.tibia_merchants_api.utils

class ImageUrl {
    companion object: Environment() {
        fun getImageUrl(itemName: String? = null, tibiaId: Int? = null): String {
            val url = environment("url_trade_img", Constants.UrlTradeImg.route) ?: Constants.UrlTradeImg.route
            val urlHouse = environment("url_trade_house_img", Constants.UrlTradeHouseImg.route) ?: Constants.UrlTradeHouseImg.route
            println("itemName: $itemName, tibiaId: $tibiaId")
            if (itemName == null) {
                return "$urlHouse$tibiaId"
            }
            val formattedName = itemName.replace(" ", "_")
            return "$url$formattedName.gif"
        }

        fun screenshotUrl(screenshotCount: Int, tibiaId: Int): MutableList<String>? {
            val url = environment("url_trade_house_screens", Constants.UrlTradeHouseScreenshot.route) ?: Constants.UrlTradeHouseScreenshot.route
            if (screenshotCount <= 0) {
                return null
            }
            val screenshotUrls = mutableListOf<String>()
            for (i in 1..screenshotCount) {
                screenshotUrls.add("$url$tibiaId/$i")
            }
            return screenshotUrls
        }
    }
}