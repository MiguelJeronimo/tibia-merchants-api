package com.miguel.tibia_merchants_api.model.Tibia

data class ToolsModels(
    val items: ArrayList<Tools>? = null
)

data class Tools(
    var name: String? = null,
    var img: String? = null,
    var arm: String? = null,
    var resist: String? = null,
    var duration: String? = null,
    var charges: String? = null,
    var level: String? = null,
    var attributes: String? = null,
    var weight: String? = null,
    var vocation: String? = null,
    var writable: String? = null,
    var radius: String? = null,
    var color: String? = null,
    var sellForNPC: String? = null,
    var buyForNPC: String? = null,
    var value: String? = null

)

data class KeysModel(
    val items: ArrayList<Key>? = null
)

data class Key(
    var name: String? = null,
    var img: String? = null,
    var location: String? = null,
    var notes: String? = null,
)