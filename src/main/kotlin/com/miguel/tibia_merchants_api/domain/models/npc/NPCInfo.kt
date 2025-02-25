package com.miguel.tibia_merchants_api.domain.models.npc

import com.miguel.tibia_merchants_api.domain.models.Item
import com.miguel.tibia_merchants_api.domain.models.Spells

data class NPCInfo(
    var name: String? = null,
    var citys: ArrayList<NameNPC>? = null,
    var description: String?= null,
    var gender: String?= null,
    var race: String?= null,
    var job: String?= null,
    var version: String?= null,
    var status: String?= null,
    var imgNPC: String?= null,
    var buyingItems: ArrayList<Item>?= null,
    var sellingItems: ArrayList<Item>?= null,
    var sellingSpells: ArrayList<Spells>?= null
)

data class NameNPC(
    val name: String? = null,
    val map: String? = null
)
