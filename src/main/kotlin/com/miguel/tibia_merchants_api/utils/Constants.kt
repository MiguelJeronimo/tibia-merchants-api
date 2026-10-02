package com.miguel.tibia_merchants_api.utils

enum class Constants(
    val route:String
){
    JsonSchemaToken(
        route = "/scha/vaemlidate_token_schema.json"
    ),
    UrlTrade(route = ""),
    UrlTradeImg(route = ""),
    UrlTradeHouseImg(route = ""),
    UrlTradeHouseScreenshot(route = "")
}