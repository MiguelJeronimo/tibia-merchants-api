package com.miguel.tibia_merchants_api.model.Tibia

data class HoldHouseItems(
    val items: ArrayList<HoldHouse>? = null
)
data class HoldHouse(
    var name: String? = null,
    var img: String? = null,
    var price: String? = null,
    var vol: String? = null,
    var weight: String? = null,
    var slots: String? = null,
    var weightPerVol: String? = null,
    var buyFrom: String? = null,
    var light: String? = null,
    var writable: String? = null
)
