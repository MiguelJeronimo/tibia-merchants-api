package com.miguel.tibia_merchants_api.utils

class ImageUrl {
    companion object {
        fun getImageUrl(itemName: String? = null, tibiaId: Int? = null): String {
            val url = Constants.UrlTradeImg.route
            val urlHouse = Constants.UrlTradeHouseImg.route
            println("itemName: $itemName, tibiaId: $tibiaId")
            if (itemName == null) {
                return "$urlHouse$tibiaId"
            }
            val formattedName = itemName.replace(" ", "_")
            return "$url$formattedName.gif"
        }

        fun screenshotUrl(screenshotCount: Int, tibiaId: Int): MutableList<String>? {
            if (screenshotCount <= 0) {
                return null
            }
            val screenshotUrls = mutableListOf<String>()
            for (i in 1..screenshotCount) {
                val url = Constants.UrlTradeHouseScreenshot.route
                screenshotUrls.add("$url$tibiaId/$i")
            }
            return screenshotUrls
        }
    }
}