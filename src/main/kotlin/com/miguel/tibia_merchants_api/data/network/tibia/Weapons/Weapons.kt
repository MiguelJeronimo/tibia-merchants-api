package Tibia.Weapons

import API.Tibia.models.*
import API.Tibia.models.Weapons
import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.data.network.tibia.ModelsScrapper.*

class Weapons(val scrapper: Scrapper, private val baseurl: String) {
    fun weapons(): Weapons {
        return Weapons(
            bows = bows(),
            crossBows = crowBows(),
            arrows = arrows(),
            bolts = bolts(),
            throwing = throwingWeapons(),
            clubs = clubWeapons(),
            swords = swordsWeapons(),
            axes = axesWeapons(),
            wands = wands()
        )
    }
    //six tables
    fun bows(): Bows {
        println("url_: ${baseurl}/Distance_Weapons")
        val request = scrapper.Soup("${baseurl}/Distance_Weapons")
        val weaponsList = ArrayList<Bow>()
        val body = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")[0].select("tbody")
        body.select("tr").forEach {
            val data = it.children()
            val image = data[1].select("img").attr("data-src")
            weaponsList.add(
                Bow(
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
        return Bows().apply {
            weapons = weaponsList
        }
    }

    fun crowBows(): CrossBows {
        println("url_: ${baseurl}/Distance_Weapons")
        val request = scrapper.Soup("${baseurl}/Distance_Weapons")
        val weaponsList = ArrayList<CrossBow>()
        val body = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")[1].select("tbody")
        body.select("tr").forEach {
            val data = it.children()
            val image = data[1].select("img").attr("data-src")
            weaponsList.add(
                CrossBow(
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
        return CrossBows().apply { weapons = weaponsList }
    }

    fun arrows(): Arrows {
        println("url_: ${baseurl}/Bow_Ammunition")
        val request = scrapper.Soup("${baseurl}/Bow_Ammunition")
        val ammunitionList = ArrayList<Arrow>()
        val body = request.getElementsByClass("wikitable sortable full-width").select("tbody")
        body.select("tr").forEach {
            val data = it.children()
            val image = data[1].select("img").attr("data-src")
            ammunitionList.add(
                Arrow(
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
        return Arrows().apply { weapons = ammunitionList }
    }

    fun bolts(): Bolts {
        println("url_: ${baseurl}/Distance_Weapons")
        val request = scrapper.Soup("${baseurl}/Distance_Weapons")
        val ammunitionList = ArrayList<Bolt>()
        val body = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")[3].select("tbody")
        body.select("tr").forEach {
            val data = it.children()
            val image = data[1].select("img").attr("data-src")
            ammunitionList.add(
                Bolt(
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
        return Bolts().apply { weapons = ammunitionList }
    }

    fun throwingWeapons(): Throwings {
        println("url_: ${baseurl}/Distance_Weapons")
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
        return Throwings().apply { weapons = ammunitionList }
    }

    /*AXES*/

    fun clubWeapons(): Club {
        println("url_: ${baseurl}/Club_Weapons")
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
            weaponsEnchantedReplicas = clubEnchanted
            weapons = clubWeaponsList
            weaponsChargedReplicas = clubCharged
        }
    }

    fun axesWeapons(): Axes {
        println("url_: ${baseurl}/Axe_Weapons")
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
            weaponsEnchantedReplicas = axesEnchanted
            weapons = axesWeaponsList
            weaponsChargedReplicas = axesCharged
        }
    }

    fun swordsWeapons(): Swords {
        println("url_: ${baseurl}/Sword_Weapons")
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
            weaponsEnchantedReplicas = swordsEnchanted
            weapons = swordsWeaponsList
            weaponsChargedReplicas = swordsCharged
        }
    }

    fun wands(): Wands {
        println("url_:${baseurl}/Wands")
        val request = scrapper.Soup("${baseurl}/Wands")
        val wandsWeaponsList = ArrayList<WandsWeapons>()
        val wandsCharged = ArrayList<WandsWeapons>()
        val tbody = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        val wandsWeapon = tbody[0].select("tbody")
        val chargedReplicas = tbody[1].select("tbody")
        wandsWeapon.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val damageTypeData = DamageType().apply {
                damageName = data[4].select("img").attr("alt").ifEmpty { null }
                imageIcon = data[4].select("img").attr("data-src").ifEmpty { null }
            }
            val club = WandsWeapons().apply {
                name = data[0].text().ifEmpty { null }
                image = imageWeapon.ifEmpty { null }
                level = data[2].text().ifEmpty { null }
                damage = data[3].text().ifEmpty { null }
                damageType = damageTypeData
                range = data[5].text().ifEmpty { null }
                mana = data[6].text().ifEmpty { null }
                resist = data[7].text().ifEmpty { null }
                slots = data[8].text().ifEmpty { null }
                classs = data[9].text().ifEmpty { null }
                weight = data[10].text().ifEmpty { null }
                attributes = data[11].text().ifEmpty { null }
            }
            wandsWeaponsList.add(club)
        }
        chargedReplicas.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val damageTypeData = DamageType().apply {
                damageName = data[3].select("img").attr("alt")
                imageIcon = data[3].select("img").attr("data-src")
            }
            val wands = WandsWeapons().apply {
                name = data[0].text().ifEmpty { null }
                image = imageWeapon.ifEmpty { null }
                damage = data[2].text().ifEmpty { null }
                damageType = damageTypeData
                range = data[4].text().ifEmpty { null }
                mana = data[5].text().ifEmpty { null }
                classs = data[6].text().ifEmpty { null }
                weight = data[7].text().ifEmpty { null }
            }
            wandsCharged.add(wands)
        }
        wandsWeaponsList.removeFirst()
        wandsCharged.removeFirst()
        return Wands().apply {
            weapons = wandsWeaponsList
            weaponsChargedReplicas = wandsCharged
        }
    }

    fun rods(): Rods {
        println("url_:${baseurl}/Rods")
        val request = scrapper.Soup("${baseurl}/Rods")
        val rodsWeaponsList = ArrayList<RodsWeapons>()
        val rodsCharged = ArrayList<RodsWeapons>()
        val tbody = request.getElementsByClass("tabber wds-tabber")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        val wandsWeapon = tbody[0].select("tbody")
        val chargedReplicas = tbody[1].select("tbody")
        wandsWeapon.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val damageTypeData = DamageType().apply {
                damageName = data[4].select("img").attr("alt").ifEmpty { null }
                imageIcon = data[4].select("img").attr("data-src").ifEmpty { null }
            }
            val rods = RodsWeapons().apply {
                name = data[0].text().ifEmpty { null }
                image = imageWeapon.ifEmpty { null }
                level = data[2].text().ifEmpty { null }
                damage = data[3].text().ifEmpty { null }
                damageType = damageTypeData
                range = data[5].text().ifEmpty { null }
                mana = data[6].text().ifEmpty { null }
                resist = data[7].text().ifEmpty { null }
                slots = data[8].text().ifEmpty { null }
                classs = data[9].text().ifEmpty { null }
                weight = data[10].text().ifEmpty { null }
                attributes = data[11].text().ifEmpty { null }
            }
            rodsWeaponsList.add(rods)
        }
        chargedReplicas.select("tr").forEach {
            val data = it.children()
            val imageWeapon = data[1].select("img").attr("data-src")
            val damageTypeData = DamageType().apply {
                damageName = data[3].select("img").attr("alt")
                imageIcon = data[3].select("img").attr("data-src")
            }
            val rods = RodsWeapons().apply {
                name = data[0].text().ifEmpty { null }
                image = imageWeapon.ifEmpty { null }
                damage = data[2].text().ifEmpty { null }
                damageType = damageTypeData
                range = data[4].text().ifEmpty { null }
                mana = data[5].text().ifEmpty { null }
                classs = data[6].text().ifEmpty { null }
                weight = data[7].text().ifEmpty { null }
            }
            rodsCharged.add(rods)
        }
        rodsWeaponsList.removeFirst()
        rodsCharged.removeFirst()
        return Rods().apply {
            weapons = rodsWeaponsList
            weaponsChargedReplicas = rodsCharged
        }
    }

    fun oldWands(): OldWands {
        println("url_:${baseurl}/Old_Wands_and_Rods")
        val request = scrapper.Soup("${baseurl}/Old_Wands_and_Rods")
        val oldWands = ArrayList<OldWand>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val oldWand = OldWand().apply {
                name = tr[0].text().ifEmpty { null }
                image = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            oldWands.add(oldWand)
        }
        return OldWands(weapons = oldWands)
    }
}