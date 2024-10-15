package com.miguel.tibia_merchants_api.domain.models

data class Errors(val statusCode: Int, val error: String)
data class Response(val statusCode: Int, val body: Any?)
