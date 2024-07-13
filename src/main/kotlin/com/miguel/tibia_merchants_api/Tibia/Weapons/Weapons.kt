package Tibia.Weapons

import API.Tibia.models.Ammunition
import API.Tibia.models.Throwing
import API.Tibia.models.Weapon
import API.Tibia.models.Weapons
import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.Tibia.ModelsScrapper.*

class Weapons(val scrapper: Scrapper, private val baseurl: String) {
    fun weapons(): Weapons {
        println("url_: ${baseurl}/Distance_Weapons")
        println("url_: ${baseurl}/Club_Weapons")
        println("url_:${baseurl}/Axe_Weapons")
        println("url_:${baseurl}/Sword_Weapons")
        return Weapons(
            bows = bows(),
            crossBows = crowBows(),
            arrows = arrows(),
            bolts = bolts(),
            throwing = throwingWeapons(),
            clubs = clubWeapons(),
            swords = swordsWeapons(),
            axes = axesWeapons()
        )
    }
    //six tables
    private fun bows(): ArrayList<Weapon> {
        val request = scrapper.Soup("${baseurl}/Distance_Weapons")
        val weaponsList = ArrayList<Weapon>()
        val body = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")[0].select("tbody")
        body.select("tr").forEach {
            val data = it.children()
            val image = data[1].select("img").attr("data-src")
            weaponsList.add(
                Weapon(
                    name = data[0].text(),
                    image = image.ifEmpty { null },
                    level = data[2].text(),
                    range = data[3].text(),
                    atkMode = data[4].text(),
                    hit = data[5].text(),
                    resist = data[6].text(),
                    embuimentSlots = data[7].text(),
                    classs = data[8].text(),
                    attributes = data[9].text(),
                    weight = data[10].text()
                )
            )
        }
        weaponsList.removeFirst()
        return weaponsList
    }
    private fun crowBows(): ArrayList<Weapon> {
        val request = scrapper.Soup("${baseurl}/Distance_Weapons")
        val weaponsList = ArrayList<Weapon>()
        val body = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")[1].select("tbody")
        body.select("tr").forEach {
            val data = it.children()
            val image = data[1].select("img").attr("data-src")
            weaponsList.add(
                Weapon(
                    name = data[0].text(),
                    image = image.ifEmpty { null },
                    level = data[2].text(),
                    range = data[3].text(),
                    atkMode = data[4].text(),
                    hit = data[5].text(),
                    resist = data[6].text(),
                    embuimentSlots = data[7].text(),
                    classs = data[8].text(),
                    attributes = data[9].text(),
                    weight = data[10].text()
                )
            )
        }
        weaponsList.removeFirst()
        return weaponsList
    }

    private fun arrows(): ArrayList<Ammunition> {
        val request = scrapper.Soup("${baseurl}/Distance_Weapons")
        val ammunitionList = ArrayList<Ammunition>()
        val body = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")[2].select("tbody")
        body.select("tr").forEach {
            val data = it.children()
            val image = data[1].select("img").attr("data-src")
            ammunitionList.add(
                Ammunition(
                    name = data[0].text(),
                    image = image.ifEmpty { null },
                    level = data[2].text(),
                    atk = data[3].text(),
                    weight = data[4].text(),
                    npcPrice = data[5].text()
                )
            )
        }
        ammunitionList.removeFirst()
        return ammunitionList
    }

    private fun bolts(): ArrayList<Ammunition> {
        val request = scrapper.Soup("${baseurl}/Distance_Weapons")
        val ammunitionList = ArrayList<Ammunition>()
        val body = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")[3].select("tbody")
        body.select("tr").forEach {
            val data = it.children()
            val image = data[1].select("img").attr("data-src")
            ammunitionList.add(
                Ammunition(
                    name = data[0].text(),
                    image = image.ifEmpty { null },
                    level = data[2].text(),
                    atk = data[3].text(),
                    weight = data[4].text(),
                    npcPrice = data[5].text()
                )
            )
        }
        ammunitionList.removeFirst()
        return ammunitionList
    }

    private fun throwingWeapons(): ArrayList<Throwing> {
        val request = scrapper.Soup("${baseurl}/Distance_Weapons")
        val ammunitionList = ArrayList<Throwing>()
        val body = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")[4]
            .select("tbody")
        body.select("tr").forEach {
            val data = it.children()
            val image = data[1].select("img").attr("data-src")
            ammunitionList.add(
                Throwing(
                    name = data[0].text(),
                    image = image.ifEmpty { null },
                    level = data[2].text(),
                    atk = data[3].text(),
                    range = data[4].text(),
                    weight = data[5].text(),
                    npcPrice = data[6].text()
                )
            )
        }
        ammunitionList.removeFirst()
        return ammunitionList
    }

    /*AXES*/

    private fun clubWeapons(): Club {
        val request = scrapper.Soup("${baseurl}/Club_Weapons")
        val clubWeaponsList = ArrayList<ClubWeapons>()
        val clubEnchanted = ArrayList<ClubWeapons>()
        val clubCharged = ArrayList<ClubWeapons>()
        val tbody = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        val clubWeapon = tbody[0].select("tbody")
        val enchantedReplicas = tbody[1].select("tbody")
        val chargedReplicas = tbody[2].select("tbody")
        clubWeapon.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[0].select("img").attr("data-src")
            val club = ClubWeapons().apply {
                name = data[0].text()
                image = imageWeapon
                level = data[1].text()
                attack = data[2].text()
                defense = data[3].text()
                defMode = data[4].text()
                hands = data[5].text()
                resist = data[6].text()
                slots = data[7].text()
                classs = data[8].text()
                weight = data[9].text()
                attributes = data[10].text()
            }
            clubWeaponsList.add(club)
        }
        enchantedReplicas.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val club = ClubWeapons().apply {
                name = data[0].text()
                image = imageWeapon
                attack = data[2].text()
                defense = data[3].text()
                hands = data[4].text()
                classs = data[5].text()
                weight = data[6].text()
            }
            clubEnchanted.add(club)
        }
        chargedReplicas.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val club = ClubWeapons().apply {
                name = data[0].text()
                image = imageWeapon
                attack = data[2].text()
                defense = data[3].text()
                hands = data[4].text()
                classs = data[5].text()
                weight = data[6].text()
            }
            clubCharged.add(club)
        }
        clubWeaponsList.removeFirst()
        clubEnchanted.removeFirst()
        clubCharged.removeFirst()
        return Club().apply {
            enchantedClubReplicas = clubEnchanted
            clubWeapons = clubWeaponsList
            chargedClubReplicas = clubCharged
        }
    }

    private fun axesWeapons(): Axes {
        val request = scrapper.Soup("${baseurl}/Axe_Weapons")
        val axesWeaponsList = ArrayList<AxesWeapons>()
        val axesEnchanted = ArrayList<AxesWeapons>()
        val axesCharged = ArrayList<AxesWeapons>()
        val tbody = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        val clubWeapon = tbody[0].select("tbody")
        val enchantedReplicas = tbody[1].select("tbody")
        val chargedReplicas = tbody[2].select("tbody")
        clubWeapon.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[0].select("img").attr("data-src")
            val club = AxesWeapons().apply {
                name = data[0].text()
                image = imageWeapon
                level = data[1].text()
                attack = data[2].text()
                defense = data[3].text()
                defMode = data[4].text()
                hands = data[5].text()
                resist = data[6].text()
                slots = data[7].text()
                classs = data[8].text()
                weight = data[9].text()
                attributes = data[10].text()
            }
            axesWeaponsList.add(club)
        }
        enchantedReplicas.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val club = AxesWeapons().apply {
                name = data[0].text()
                image = imageWeapon
                attack = data[2].text()
                defense = data[3].text()
                hands = data[4].text()
                classs = data[5].text()
                weight = data[6].text()
            }
            axesEnchanted.add(club)
        }
        chargedReplicas.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val club = AxesWeapons().apply {
                name = data[0].text()
                image = imageWeapon
                attack = data[2].text()
                defense = data[3].text()
                hands = data[4].text()
                classs = data[5].text()
                weight = data[6].text()
            }
            axesCharged.add(club)
        }
        axesWeaponsList.removeFirst()
        axesEnchanted.removeFirst()
        axesCharged.removeFirst()
        return Axes().apply {
            enchantedAxesReplicas = axesEnchanted
            axesWeapons = axesWeaponsList
            chargedAxesReplicas = axesCharged
        }
    }

    private fun swordsWeapons(): Swords {
        val request = scrapper.Soup("${baseurl}/Sword_Weapons")
        val swordsWeaponsList = ArrayList<SwordsWeapons>()
        val swordsEnchanted = ArrayList<SwordsWeapons>()
        val swordsCharged = ArrayList<SwordsWeapons>()
        val tbody = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        val clubWeapon = tbody[0].select("tbody")
        val enchantedReplicas = tbody[1].select("tbody")
        val chargedReplicas = tbody[2].select("tbody")
        clubWeapon.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[0].select("img").attr("data-src")
            val club = SwordsWeapons().apply {
                name = data[0].text()
                image = imageWeapon
                level = data[1].text()
                attack = data[2].text()
                defense = data[3].text()
                defMode = data[4].text()
                hands = data[5].text()
                resist = data[6].text()
                slots = data[7].text()
                classs = data[8].text()
                weight = data[9].text()
                attributes = data[10].text()
            }
            swordsWeaponsList.add(club)
        }
        enchantedReplicas.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val club = SwordsWeapons().apply {
                name = data[0].text()
                image = imageWeapon
                attack = data[2].text()
                defense = data[3].text()
                hands = data[4].text()
                classs = data[5].text()
                weight = data[6].text()
            }
            swordsEnchanted.add(club)
        }
        chargedReplicas.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val club = SwordsWeapons().apply {
                name = data[0].text()
                image = imageWeapon
                attack = data[2].text()
                defense = data[3].text()
                hands = data[4].text()
                classs = data[5].text()
                weight = data[6].text()
            }
            swordsCharged.add(club)
        }
        swordsWeaponsList.removeFirst()
        swordsEnchanted.removeFirst()
        swordsCharged.removeFirst()
        return Swords().apply {
            enchantedSwordsReplicas = swordsEnchanted
            swordsWeapons = swordsWeaponsList
            chargedSwordsReplicas = swordsCharged
        }
    }
}