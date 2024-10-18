package com.miguel.tibia_merchants_api.data.network.tibia.spells

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.spells.Effect
import com.miguel.tibia_merchants_api.domain.models.spells.Runes
import com.miguel.tibia_merchants_api.domain.models.spells.Spell
import com.miguel.tibia_merchants_api.domain.models.spells.Spells

class TibiaSpells(val scrapper: Scrapper, private val baseurl: String) {
    private val url = "$baseurl/Spells"
    private val request = scrapper.Soup(url)

    fun spellList(): Spells {
        return Spells().apply {
            spells = spells()
            runes = runeSpells()
        }
    }

    private fun spells(): ArrayList<Spell> {
        val table = request.select("table")[0]
        val tbody = table.select("tbody")
        val tr = tbody.select("tr")
        val spellList = ArrayList<Spell>()
        tr.forEach {
            val td = it.children()
            if (td[1].select("a").attr("title").isNotEmpty()){
                var spell = Spell().apply {
                    val pattern = "/wiki/"
                    val imge = td[8].select("a").attr("href")
                    val effects = Effect().apply {
                        description = td[8].text()
                        img = (if (imge.contains(pattern)) "" else imge).ifEmpty { null }
                    }
                    name = td[1].select("a").attr("title")
                    img = td[1].select("a").select("img").attr("data-src")
                        .ifEmpty { null }
                    formula = td[2].text()
                    premium = td[3].text()
                    level = td[4].text()
                    mana = td[5].text()
                    price = td[6].text()
                    group = td[7].text()
                    effect = effects
                }
                spellList.add(spell)
            }
        }
        return spellList
    }

    private fun runeSpells(): ArrayList<Runes> {
        val table = request.select("table")[1]
        val tbody = table.select("tbody")
        val tr = tbody.select("tr")
        val runesArray = ArrayList<Runes>()
        tr.forEach {
            val td = it.children()
            if (td[1].select("a").attr("title").isNotEmpty()){
                val rune = Runes().apply {
                    val imge = td[10].select("a").select("img").attr("data-src")
                    val effects = Effect().apply {
                        description = td[10].text()
                        img = imge.ifEmpty { null }
                    }
                    name = td[1].select("a").attr("title")
                    img = td[1].select("a").select("img").attr("data-src")
                        .ifEmpty { null }
                    formula = td[2].text()
                    premium = td[3].text()
                    level = td[4].text()
                    soul_points = td[5].text()
                    Amount = td[6].text()
                    mana = td[7].text()
                    price = td[8].text()
                    rune_group = td[9].text()
                    effect = effects
                }
                runesArray.add(rune)
            }
        }
        return runesArray
    }

}