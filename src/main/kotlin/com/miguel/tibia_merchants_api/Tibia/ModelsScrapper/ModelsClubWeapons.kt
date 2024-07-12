package com.miguel.tibia_merchants_api.Tibia.ModelsScrapper

data class Club(
    var clubWeapons: ArrayList<ClubWeapons>? = null,
    var enchantedClubReplicas: ArrayList<ClubWeapons>? = null,
    var chargedClubReplicas: ArrayList<ClubWeapons>? = null
)


data class ClubWeapons(
    var name: String? = null,
    var image: String? = null,
    var level:String? = null,
    var attack: String? = null,
    var defense: String? = null,
    var defMode: String? = null,
    var hands:String? = null,
    var resist: String? = null,
    var slots:String? = null,
    var classs:String? = null,
    var weight: String? = null,
    var attributes: String? = null
)