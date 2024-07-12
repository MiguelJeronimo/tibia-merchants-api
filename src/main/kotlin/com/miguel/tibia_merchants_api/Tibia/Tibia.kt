package Tibia


import Jsoup.Scrapper
import Tibia.Blessings.Blessings
import Tibia.Catalog.CatalogGame
import Tibia.Items.Items
import Tibia.Vocations.Vocations
import com.miguel.tibia_merchants_api.Tibia.Items.bodyequipment.EquipmentList
import com.miguel.tibia_merchants_api.Tibia.TibiaNPCs
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

    fun item(name: String): ArrayList<ItemEquipment> {
        return EquipmentList(scrapper, baseurl, name).item()
    }
}