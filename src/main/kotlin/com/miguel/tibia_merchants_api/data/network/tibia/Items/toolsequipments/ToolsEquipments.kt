package com.miguel.tibia_merchants_api.data.network.tibia.Items.toolsequipments

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.Key
import com.miguel.tibia_merchants_api.domain.models.KeysModel
import com.miguel.tibia_merchants_api.domain.models.Tools
import com.miguel.tibia_merchants_api.domain.models.ToolsModels

class ToolsEquipments(val scrapper: Scrapper, private val baseurl: String) {
    fun amuletsAndNecklaces(): ToolsModels {
        println("url_:${baseurl}/Amulets_and_Necklaces")
        val request = scrapper.Soup("${baseurl}/Amulets_and_Necklaces")
        val items = ArrayList<Tools>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Tools().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                arm = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
                attributes = tr[4].text().ifEmpty { null }
                resist = tr[5].text().ifEmpty { null }
                duration = tr[6].text().ifEmpty { null }
                charges = tr[7].text().ifEmpty { null }
                level = tr[8].text().ifEmpty { null }
                vocation = tr[9].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return ToolsModels( items = items)
    }

    fun keys(): KeysModel {
        println("url_:${baseurl}/Keys")
        val request = scrapper.Soup("${baseurl}/Keys")
        val items = ArrayList<Key>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Key().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                location = tr[2].text().ifEmpty { null }
                notes = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        items.removeIf { it.name == "Name" }
        return KeysModel( items = items)
    }

    fun ligthSources(): ToolsModels {
        println("url_:${baseurl}/Light Sources")
        val request = scrapper.Soup("${baseurl}/Light Sources")
        val items = ArrayList<Tools>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Tools().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                attributes = tr[2].text().ifEmpty { null }
                resist = tr[3].text().ifEmpty { null }
                weight = tr[4].text().ifEmpty { null }
                tr[5].getElementsByClass("colorbox").attr("style").also {
                    val colors = it.replace("background-color: ","")
                        .replace("; width: 1em; height: 1em; display: inline-block;", "")
                    color = colors.ifEmpty { null }
                }
                radius = tr[6].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return ToolsModels( items = items)
    }

    fun plaintingEquipment(): ToolsModels {
        println("url_:${baseurl}/Painting_Equipment")
        val request = scrapper.Soup("${baseurl}/Painting_Equipment")
        val items = ArrayList<Tools>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Tools().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                attributes = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return ToolsModels( items = items)
    }

    fun rings(): ToolsModels {
        println("url_:${baseurl}/Rings")
        val request = scrapper.Soup("${baseurl}/Rings")
        val items = ArrayList<Tools>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Tools().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                arm = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
                attributes = tr[4].text().ifEmpty { null }
                resist = tr[5].text().ifEmpty { null }
                duration = tr[6].text().ifEmpty { null }
                charges = tr[7].text().ifEmpty { null }
                level = tr[8].text().ifEmpty { null }
                vocation = tr[9].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return ToolsModels( items = items)
    }

    fun tools(): ToolsModels {
        println("url_:${baseurl}/Tools")
        val request = scrapper.Soup("${baseurl}/Tools")
        val items = ArrayList<Tools>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Tools().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return ToolsModels( items = items)
    }

    fun tamingItems(): ToolsModels {
        println("url_:${baseurl}/Taming_Items")
        val request = scrapper.Soup("${baseurl}/Taming_Items")
        val items = ArrayList<Tools>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Tools().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[2].text().ifEmpty { null }
                sellForNPC = tr[3].text().ifEmpty { null }
                buyForNPC = tr[4].text().ifEmpty { null }
                value = tr[5].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return ToolsModels( items = items)
    }

    fun divingEquipment(): ToolsModels {
        println("url_:${baseurl}/Diving_Equipment")
        val request = scrapper.Soup("${baseurl}/Diving_Equipment")
        val items = ArrayList<Tools>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Tools().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return ToolsModels( items = items)
    }

}