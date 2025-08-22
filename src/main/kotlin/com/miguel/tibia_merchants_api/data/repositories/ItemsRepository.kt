package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Weapons
import com.miguel.tibia_merchants_api.domain.models.Profile
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog

interface ItemsRepository {
    suspend fun items(): ItemsCatalog?
    suspend fun item(name: String): Profile?
    suspend fun bodyEquipments(name: String): ArrayList<ItemEquipment>?
    suspend fun weapons(name: String): Any?
    suspend fun weapons(): Weapons?
    suspend fun household(name: String): Any?
    suspend fun others(name: String): Any?
    suspend fun othersEquipments(name: String): Any?
    suspend fun otherItems(name:String): Any?
}