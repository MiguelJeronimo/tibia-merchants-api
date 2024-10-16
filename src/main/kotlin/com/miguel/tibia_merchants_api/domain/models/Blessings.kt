package com.miguel.tibia_merchants_api.domain.models

import org.springframework.cache.annotation.Cacheable

data class Blessing(
    @get:Cacheable var description: String? = null,
    @get:Cacheable var blessings: ArrayList<Blessings>? = null
)
data class Blessings(
    var name: String? = null,
    var npc_location: String? = null,
    var img: String? = null,
    var store_price: String? = null,
    var aditional_info: String? = null,
    var premium: String? = null,
)