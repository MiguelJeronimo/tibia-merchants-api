package Tibia


import Jsoup.Scrapper
import Tibia.Blessings.Blessings
import Tibia.Catalog.CatalogGame
import Tibia.Items.Items
import Tibia.Vocations.Vocations
import com.miguel.tibia_merchants_api.Tibia.Items.bodyequipment.EquipmentList
import com.miguel.tibia_merchants_api.Tibia.Items.ohters.Other
import com.miguel.tibia_merchants_api.Tibia.TibiaNPCs
import com.miguel.tibia_merchants_api.Tibia.householdItems.HouseholdItems
import model.Tibia.ItemEquipment
import Tibia.Weapons.Weapons as Weapons

@Suppress("IMPLICIT_CAST_TO_ANY")
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

    fun npcsDefault(nameNPC: String): Any? {
        val npc = when (nameNPC){
            "Rashid"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").rashid()}
            "Yasir"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").yasir()}
            "Haroun"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").horoun()}
            "Nah Bob"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").nashBob()}
            "Asnarus"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").asnarus()}
            "Alesar"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").alesar()}
            "Yalam"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").yalam()}
            "Esrik"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").esrik()}
            "Alexander"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").alexander()}
            "Tamoril"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").tamoril()}
            "Grizzly Adams"-> {TibiaNPCs(scrapper, url = "${baseurl}/${nameNPC}").grizzlyAdams()}
            else -> {null}
        }
        return npc
    }

    fun bodyEquipments(name: String): ArrayList<ItemEquipment> {
        return EquipmentList(scrapper, baseurl, name).item()
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

}