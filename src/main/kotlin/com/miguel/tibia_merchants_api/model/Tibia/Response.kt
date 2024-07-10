package com.miguel.tibia_merchants_api.model.Tibia

data class Errors(val statusCode: Int, val error: String)
data class Response(val statusCode: Int, val body: Any?)
