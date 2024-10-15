package com.miguel.tibia_merchants_api.domain.models

data class OtherModel(
    val items: ArrayList<Others>? = null
)

data class Others(
    var name: String? = null,
    var img: String? = null,
    var price: String? = null,
    var attributes: String? = null,
    var weight: String? = null,
    var writable: String? = null,
    var stackable: String? = null
)

data class OtherItemsModel(
    val items: ArrayList<OtherItems>? = null
)

data class OtherItems(
    var name: String? = null,
    var img: String? = null,
    var price: String? = null,
    var attributes: String? = null,
    var weight: String? = null,
    var writable: String? = null,
    var pickupable: String? = null,
    var stackable: String? = null,
    var sellForNPC: String? = null,
    var buyForNPC: String? = null,
    var value: String? = null
)

data class RunesItemsList(
    val items: ArrayList<RunesItem>? = null
)

data class RunesItem(
    var name: String? = null,
    var img: String? = null,
    var type: String? = null,
    var level: String? = null,
    var magicLevel: String? = null,
    var npcPrice: String? = null,
    var weight: String? = null,
)