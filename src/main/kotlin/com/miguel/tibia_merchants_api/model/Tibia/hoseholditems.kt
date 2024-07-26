package com.miguel.tibia_merchants_api.model.Tibia

data class Books(
    val books: ArrayList<Book>? = null
)
data class Book(
    var name: String? = null,
    var img: String? = null,
    var price: String? = null,
    var arm: String? = null,
    var defense: String? = null,
    var vol: String? = null,
    var weight: String? = null,
    var attributes: String? = null,
    var resist: String? = null,
    var slots: String? = null,
    var classs: String? = null,
    var level: String? = null,
    var vocation: String? = null,
    var weightPerVol: String? = null,
    var buyFrom: String? = null,
    var light: String? = null,
    var writable: String? = null
)
