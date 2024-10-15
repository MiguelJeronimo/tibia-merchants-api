package com.miguel.tibia_merchants_api.domain.usecase

import API.Tibia.models.Weapons
import com.miguel.tibia_merchants_api.data.repositories.ItemsRepository
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog

class UseCaseItems(val repository: ItemsRepository) {
    fun items(): ItemsCatalog? {
        return repository.items()
    }

    fun type(title: String, name: String): Any? {
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

    fun equipments(name: String): ArrayList<ItemEquipment>? {
        return repository.bodyEquipments(name)
    }

    fun weapons(name: String): Any? {
        return repository.weapons(name)
    }

    fun weapons(): Weapons? {
        return repository.weapons()
    }
}