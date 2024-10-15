package com.miguel.tibia_merchants_api.data.repositories

interface NPCRepository {
    fun npc(name:String): Any?
}