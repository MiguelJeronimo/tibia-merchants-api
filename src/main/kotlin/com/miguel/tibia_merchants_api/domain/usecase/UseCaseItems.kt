package com.miguel.tibia_merchants_api.domain.usecase

import API.Tibia.models.Weapons
import com.miguel.tibia_merchants_api.data.repositories.ItemsRepository
import com.miguel.tibia_merchants_api.data.repositories.wikipediaapi.RepositoryWikiTibia
import com.miguel.tibia_merchants_api.domain.models.Profile
import model.Tibia.ItemEquipment
import model.Tibia.ItemsCatalog

class UseCaseItems(private val repository: ItemsRepository, private val repositoryWikiTibia: RepositoryWikiTibia) {
    suspend fun items(): ItemsCatalog? {
        val response = repositoryWikiTibia.getWikiContent("items")
        val html = response.parse?.text?.content.toString()
        return repository.items(html = html)
    }

    suspend fun item(name: String): Profile? {
        val response = repositoryWikiTibia.getWikiContent(name)
        val html = response.parse?.text?.content.toString()
        return repository.item(name, html = html)
    }

    suspend fun type(title: String, name: String): Any? {
        val response = repositoryWikiTibia.getWikiContent(name)
        val html = response.parse?.text?.content.toString()
        return when(title.lowercase()){
            "body equipment"-> repository.bodyEquipments(name, html = html)
            "weapons"-> repository.weapons(name, html = html)
            "household items"-> repository.household(name, html = html)
            "plants, animal products, food and drink"-> repository.others(name, html = html)
            "tools and other equipment"-> repository.othersEquipments(name, html = html)
            "other items"-> repository.otherItems(name, html = html)
            //""-> "RepositoryItems().item(name)"
            else -> null
        }
    }

    suspend fun equipments(name: String): ArrayList<ItemEquipment>? {
        return repository.bodyEquipments(name,"")
    }


    suspend fun weapons(): Weapons? {
        val response = repositoryWikiTibia.getWikiContent("")
        val html = response.parse?.text?.content.toString()
        return repository.weapons()
    }
}