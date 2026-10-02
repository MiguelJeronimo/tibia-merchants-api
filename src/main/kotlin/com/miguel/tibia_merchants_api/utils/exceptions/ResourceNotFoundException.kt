package com.miguel.tibia_merchants_api.utils.exceptions

class ResourceNotFoundException(message:String, cause:Throwable? = null): RuntimeException(message, cause)