package com.miguel.tibia_merchants_api.data.repositories

import API.Tibia.models.Weapons
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog

interface ItemsRepository {
    fun items(): ItemsCatalog?
    fun bodyEquipments(name: String): ArrayList<ItemEquipment>?
    fun weapons(name: String): Any?
    fun weapons(): Weapons?
    fun household(name: String): Any?
    fun others(name: String): Any?
    fun othersEquipments(name: String): Any?
    fun otherItems(name:String): Any?
}