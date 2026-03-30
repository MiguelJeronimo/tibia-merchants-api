package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Weapons
import com.miguel.tibia_merchants_api.domain.models.Profile
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog

interface ItemsRepository {
    suspend fun items(html: String): ItemsCatalog?
    suspend fun item(name: String, html: String): Profile?
    suspend fun bodyEquipments(name: String, html: String): ArrayList<ItemEquipment>?
    suspend fun weapons(name: String, html: String): Any?
    suspend fun weapons(): Weapons?
    suspend fun household(name: String, html: String): Any?
    suspend fun others(name: String, html: String): Any?
    suspend fun othersEquipments(name: String, html: String): Any?
    suspend fun otherItems(name: String, html: String): Any?
}