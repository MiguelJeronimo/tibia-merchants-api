package com.miguel.tibia_merchants_api.domain.usecase

import API.Tibia.models.Weapons
import com.miguel.tibia_merchants_api.data.repositories.ItemsRepository
import com.miguel.tibia_merchants_api.domain.models.Profile
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog

class UseCaseItems(val repository: ItemsRepository) {
    suspend fun items(): ItemsCatalog? {
        return repository.items()
    }

    suspend fun item(name: String): Profile? {
        return repository.item(name)
    }

    suspend fun type(title: String, name: String): Any? {
        return when(title.lowercase()){
            "body equipment"-> repository.bodyEquipments(name)
            "weapons"-> repository.weapons(name)
            "household items"-> repository.household(name)
            "plants, animal products, food and drink"-> repository.others(name)
            "tools and other equipment"-> repository.othersEquipments(name)
            "other items"-> repository.otherItems(name)
            //""-> "RepositoryItems().item(name)"
            else -> null
        }
    }

    suspend fun equipments(name: String): ArrayList<ItemEquipment>? {
        return repository.bodyEquipments(name)
    }


    suspend fun weapons(): Weapons? {
        return repository.weapons()
    }
}