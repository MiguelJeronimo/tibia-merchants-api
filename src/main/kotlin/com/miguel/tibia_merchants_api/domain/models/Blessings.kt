package com.miguel.tibia_merchants_api.domain.models

import org.springframework.cache.annotation.Cacheable

data class Blessing(val blessings: ArrayList<Blessings>? = null)
data class Blessings(
    @get:Cacheable var name: String? = null,
    @get:Cacheable var npc_location: String? = null,
    @get:Cacheable var img: String? = null,
    @get:Cacheable var store_price: String? = null,
    @get:Cacheable var aditional_info: String? = null,
    @get:Cacheable var premium: String? = null,
)