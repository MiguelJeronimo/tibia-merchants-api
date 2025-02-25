package com.miguel.tibia_merchants_api.data.network


import Jsoup.Scrapper
import Tibia.Blessings.Blessings
import Tibia.Catalog.CatalogGame
import Tibia.Items.Items
import Tibia.Vocations.Vocations
import com.miguel.tibia_merchants_api.Tibia.TibiaNPCs
import com.miguel.tibia_merchants_api.data.network.tibia.Items.bodyequipment.EquipmentList
import com.miguel.tibia_merchants_api.data.network.tibia.Items.bodyequipment.ItemProfileBodyEquipment
import com.miguel.tibia_merchants_api.data.network.tibia.Items.ohters.Other
import com.miguel.tibia_merchants_api.data.network.tibia.Items.ohters.OtherItem
import com.miguel.tibia_merchants_api.data.network.tibia.Items.toolsequipments.ToolsEquipments
import com.miguel.tibia_merchants_api.data.network.tibia.NPCProfile
import com.miguel.tibia_merchants_api.data.network.tibia.householdItems.HouseholdItems
import com.miguel.tibia_merchants_api.data.network.tibia.spells.TibiaSpells
import com.miguel.tibia_merchants_api.domain.models.Profile
import com.miguel.tibia_merchants_api.domain.models.npc.NPCInfo
import com.miguel.tibia_merchants_api.domain.models.spells.Spells
import model.Tibia.ItemEquipment
import Tibia.Weapons.Weapons as Weapons


class Tibia {
    private val baseurl = "https://tibia.fandom.com/wiki"
    private val scrapper = Scrapper()

    fun weapons(): Weapons {
        return Weapons(scrapper, baseurl)
    }

    fun catalog(): CatalogGame {
        return CatalogGame(scrapper, baseurl)
    }

    fun vocations(): Vocations {
        return Vocations(scrapper, baseurl)
    }

    fun items(): Items {
        return Items(scrapper, baseurl)
    }

    fun blessings(): Blessings {
        return Blessings(scrapper, baseurl)
    }

    @Suppress("IMPLICIT_CAST_TO_ANY")
    fun npcsDefault(nameNPC: String): Any? {
        //https://tibia.fandom.com/wiki/Nah'Bob
        val npc = when (nameNPC){
            "Rashid"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").rashid()
            "Yasir"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").yasir()
            "Haroun"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").horoun()
            "Nah'Bob"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").nashBob()
            "Asnarus"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").asnarus()
            "Alesar"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").alesar()
            "Yaman"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").yalam()
            "Esrik"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").esrik()
            "Alexander"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").alexander()
            "Tamoril"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").tamoril()
            "Grizzly Adams"-> TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").grizzlyAdams()
            else -> null
        }
        return npc
    }

    fun npc(name:String): NPCInfo {
        val npc = NPCProfile(scrapper, baseurl).information(name)
        return npc
    }

    fun bodyEquipments(name: String): ArrayList<ItemEquipment> {
        return EquipmentList(scrapper, baseurl, name).item()
    }

    fun itemProfileItems(name: String): Profile {
        return ItemProfileBodyEquipment(scrapper, baseurl, name).item()
    }

    fun household(name: String): Any? {
        val household = when(name.lowercase()){
            "books"-> HouseholdItems(scrapper, baseurl).books()
            "carpets"-> HouseholdItems(scrapper, baseurl).carpets()
            "containers"-> HouseholdItems(scrapper, baseurl).containers()
            "contest prizes"-> HouseholdItems(scrapper, baseurl).contestPrizes()
            "fansite items"-> HouseholdItems(scrapper, baseurl).fanSiteItems()
            "decorations"-> HouseholdItems(scrapper, baseurl).decorations()
            "documents and papers"-> HouseholdItems(scrapper, baseurl).documentsAndPapers()
            "dolls and bears"-> HouseholdItems(scrapper, baseurl).dollsAndBears()
            "furniture"-> HouseholdItems(scrapper, baseurl).furniture()
            "kitchen tools"-> HouseholdItems(scrapper, baseurl).kitchenTools()
            "musical instruments"-> HouseholdItems(scrapper, baseurl).musicalInstruments()
            "trophies"-> HouseholdItems(scrapper, baseurl).trophies()
            else-> null
        }
        return household
    }

    fun others(name: String): Any? {
        val ohters = when(name.lowercase()){
            "creature products"-> Other(scrapper, baseurl).creatureProducts()
            "food"-> Other(scrapper, baseurl).food()
            "liquids"-> Other(scrapper, baseurl).liquids()
            "plants and herbs"-> Other(scrapper, baseurl).plantsAndHerbs()
            else-> null
        }
        return ohters
    }

    fun toolsEquipments(name: String): Any? {
        println("NAME: $name")
        val equipments = when(name.lowercase()){
            "amulets and necklaces"-> ToolsEquipments(scrapper, baseurl).amuletsAndNecklaces()
            "keys"-> ToolsEquipments(scrapper, baseurl).keys()
            "light sources"-> ToolsEquipments(scrapper, baseurl).ligthSources()
            "painting equipment"-> ToolsEquipments(scrapper, baseurl).plaintingEquipment()
            "rings"-> ToolsEquipments(scrapper, baseurl).rings()
            "tools"-> ToolsEquipments(scrapper, baseurl).tools()
            "taming items"-> ToolsEquipments(scrapper, baseurl).tamingItems()
            "diving equipment"-> ToolsEquipments(scrapper, baseurl).divingEquipment()
            else-> null
        }
        return equipments
    }

    fun otherItems(name: String): Any? {
        val equipments = when(name.lowercase()){
            "clothing accessories"-> OtherItem(scrapper, baseurl).clothingAccesories()
            "enchanted items"-> OtherItem(scrapper, baseurl).enchantedItems()
            "game tokens"-> OtherItem(scrapper, baseurl).gameTokens()
            "valuables"-> OtherItem(scrapper, baseurl).valuables()
            "magical items"-> OtherItem(scrapper, baseurl).magicalItems()
            "metals"-> OtherItem(scrapper, baseurl).metals()
            "party items"-> OtherItem(scrapper, baseurl).partyItems()
            "blessing charms"-> OtherItem(scrapper, baseurl).blessingsCharms()
            "quest items"-> OtherItem(scrapper, baseurl).questItems()
            "rubbish"-> OtherItem(scrapper, baseurl).rubbish()
            "runes"-> OtherItem(scrapper, baseurl).runes()
            else-> null
        }
        return equipments
    }

    fun spells(): Spells {
        return TibiaSpells(baseurl = baseurl, scrapper = scrapper).spellList()
    }
}