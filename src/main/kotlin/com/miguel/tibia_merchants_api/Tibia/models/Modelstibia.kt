package API.Tibia.models

import com.miguel.tibia_merchants_api.Tibia.ModelsScrapper.*

data class Weapons(
    val bows: Bows,
    val crossBows: CrossBows,
    val arrows: Arrows,
    val bolts: Bolts,
    val throwing: Throwings,
    val clubs: Club?,
    val swords: Swords,
    val axes: Axes,
    val wands: Wands,
)

data class Bows(
    var weapons: ArrayList<Bow>? = null,
    var weaponsEnchantedReplicas: ArrayList<Bow>? = null,
    var weaponsChargedReplicas: ArrayList<Bow>? = null
)

data class Bow(
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
    var attributes: String? = null,
    val range: String? = null,
    val atkMode: String? = null,
    val hit: String? = null,
    val embuimentSlots: String? = null,
    val atk: String? = null,
    val npcPrice: String? = null
)


data class CrossBows(
    var weapons: ArrayList<CrossBow>? = null,
    var weaponsEnchantedReplicas: ArrayList<CrossBow>? = null,
    var weaponsChargedReplicas: ArrayList<CrossBow>? = null
)

data class CrossBow(
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
    var attributes: String? = null,
    val range: String? = null,
    val atkMode: String? = null,
    val hit: String? = null,
    val embuimentSlots: String? = null,
    val atk: String? = null,
    val npcPrice: String? = null
)

data class Arrows (
    var weapons: ArrayList<Arrow>? = null,
    var weaponsEnchantedReplicas: ArrayList<Arrow>? = null,
    var weaponsChargedReplicas: ArrayList<Arrow>? = null
)

data class Arrow(
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
    var attributes: String? = null,
    val range: String? = null,
    val atkMode: String? = null,
    val hit: String? = null,
    val embuimentSlots: String? = null,
    val atk: String? = null,
    val npcPrice: String? = null
)

data class Bolts(
    var weapons: ArrayList<Bolt>? = null,
    var weaponsEnchantedReplicas: ArrayList<Bolt>? = null,
    var weaponsChargedReplicas: ArrayList<Bolt>? = null
)

data class Bolt(
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
    var attributes: String? = null,
    val range: String? = null,
    val atkMode: String? = null,
    val hit: String? = null,
    val embuimentSlots: String? = null,
    val atk: String? = null,
    val npcPrice: String? = null
)

/**
 * Name: Yol's Bow
 * Imagen: https://static.wikia.nocookie.net/tibia/images/1/19/Yol%27s_Bow.gif/revision/latest?cb=20080624232723&path-prefix=en
 * Lvl: 60
 * Range: 7
 * Atk Mod:
 * Hit%: +7
 * Resist:
 * Imb. Slots: 0
 * Class: 4
 * Attributes:
 * Weight: 35.00
 *
 * **/
data class Weapon(
    val name: String? = null,
    val image: String? = null,
    val level:String? = null,
    val range: String? = null,
    val atkMode: String? = null,
    val hit: String? = null,
    val resist:String? = null,
    val embuimentSlots: String? = null,
    val classs:String? = null,
    val attributes:String? = null,
    val weight: String? = null
)

data class Throwings(
    var weapons: ArrayList<Throwing>? = null,
    var weaponsEnchantedReplicas: ArrayList<Throwing>? = null,
    var weaponsChargedReplicas: ArrayList<Throwing>? = null
)

data class Throwing(
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
    var attributes: String? = null,
    val range: String? = null,
    val atkMode: String? = null,
    val hit: String? = null,
    val embuimentSlots: String? = null,
    val atk: String? = null,
    val npcPrice: String? = null
)

data class Catalog(
    val name: String? = null,
    val image: String? = null,
)

//Vocations
data class Vocations(
    val name: String,
    val description: String,
)
data class Vocation(
    var description: String? = null,
    var spells: ArrayList<Spell> ? = null,
    var spellsIsNotAvaible: ArrayList<Spell>? = null,
    var runeSpells: ArrayList<RuneSpell>? = null
)

data class Spell(
    val name: String? = null,
    val image: String? = null,
    val formula: String? = null,
    val premium: String? = null,
    val level: String? = null,
    val mana: String? = null,
    val price: String? = null,
    val group: String? = null,
    val effect: String? = null,
)

data class RuneSpell(
    val name: String? = null,
    val image: String? = null,
    val formula: String? = null,
    val premium: String? = null,
    val level: String? = null,
    val mana: String? = null,
    val price: String? = null,
    val group: String? = null,
    val effect: String? = null
)