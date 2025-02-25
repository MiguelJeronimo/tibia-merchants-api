package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.domain.models.npc.NPCInfo

interface NPCRepository {
    fun npc(name:String): Any?
    fun npcInfo(name:String): NPCInfo?
}