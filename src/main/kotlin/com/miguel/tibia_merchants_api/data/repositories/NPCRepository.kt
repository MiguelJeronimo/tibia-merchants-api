package com.miguel.tibia_merchants_api.data.repositories

import com.miguel.tibia_merchants_api.domain.models.npc.NPCInfo

interface NPCRepository {
    suspend fun npc(name:String): Any?
    suspend fun npcInfo(name:String): NPCInfo?
}