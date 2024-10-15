package com.miguel.tibia_merchants_api.data.network.tibia.ModelsScrapper

data class Club(
    var weapons: ArrayList<ClubWeapons>? = null,
    var weaponsEnchantedReplicas: ArrayList<ClubWeapons>? = null,
    var weaponsChargedReplicas: ArrayList<ClubWeapons>? = null
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

data class Axes(
    var weapons: ArrayList<AxesWeapons>? = null,
    var weaponsEnchantedReplicas: ArrayList<AxesWeapons>? = null,
    var weaponsChargedReplicas: ArrayList<AxesWeapons>? = null
)


data class AxesWeapons(
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

data class Swords(
    var weapons: ArrayList<SwordsWeapons>? = null,
    var weaponsEnchantedReplicas: ArrayList<SwordsWeapons>? = null,
    var weaponsChargedReplicas: ArrayList<SwordsWeapons>? = null
)


data class SwordsWeapons(
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

data class Wands(
    var weapons: ArrayList<WandsWeapons>? = null,
    var weaponsEnchantedReplicas: ArrayList<WandsWeapons>? = null,
    var weaponsChargedReplicas: ArrayList<WandsWeapons>? = null
)

data class WandsWeapons(
    var name: String? = null,
    var image: String? = null,
    var level:String? = null,
    var damage: String? = null,
    var damageType: DamageType? = null,
    var range: String? = null,
    var mana: String? = null,
    var resist:String? = null,
    var slots: String? = null,
    var classs:String? = null,
    var weight:String? = null,
    var attributes: String? = null,
)

data class Rods(
    var weapons: ArrayList<RodsWeapons>? = null,
    var weaponsEnchantedReplicas: ArrayList<RodsWeapons>? = null,
    var weaponsChargedReplicas: ArrayList<RodsWeapons>? = null
)

data class RodsWeapons(
    var name: String? = null,
    var image: String? = null,
    var level:String? = null,
    var damage: String? = null,
    var damageType: DamageType? = null,
    var range: String? = null,
    var mana: String? = null,
    var resist:String? = null,
    var slots: String? = null,
    var classs:String? = null,
    var weight:String? = null,
    var attributes: String? = null
)

data class DamageType(
    var damageName: String? = null,
    var imageIcon: String? = null
)

data class OldWands(
    var weapons: ArrayList<OldWand>? = null,
    var weaponsEnchantedReplicas: ArrayList<OldWand>? = null,
    var weaponsChargedReplicas: ArrayList<OldWand>? = null
)

data class OldWand(
    var name: String? = null,
    var image: String? = null,
    var level:String? = null,
    var damage: String? = null,
    var damageType: DamageType? = null,
    var range: String? = null,
    var mana: String? = null,
    var resist:String? = null,
    var slots: String? = null,
    var classs:String? = null,
    var weight:String? = null,
    var attributes: String? = null
)
