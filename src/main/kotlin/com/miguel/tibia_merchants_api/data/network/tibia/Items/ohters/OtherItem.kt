package com.miguel.tibia_merchants_api.data.network.tibia.Items.ohters

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.OtherItems
import com.miguel.tibia_merchants_api.domain.models.OtherItemsModel
import com.miguel.tibia_merchants_api.domain.models.RunesItem
import com.miguel.tibia_merchants_api.domain.models.RunesItemsList

class OtherItem(val scrapper: Scrapper, private val baseurl: String) {
    fun clothingAccesories(): OtherItemsModel {
        println("url_:${baseurl}/Clothing_Accessories")
        val request = scrapper.Soup("${baseurl}/Clothing_Accessories")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherItemsModel( items = items)
    }

    fun enchantedItems(): OtherItemsModel {
        println("url_:${baseurl}/Enchanted_Items")
        val request = scrapper.Soup("${baseurl}/Enchanted_Items")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherItemsModel( items = items)
    }

    fun gameTokens(): OtherItemsModel {
        println("url_:${baseurl}/Game_Tokens")
        val request = scrapper.Soup("${baseurl}/Game_Tokens")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherItemsModel( items = items)
    }

    fun valuables(): OtherItemsModel {
        println("url_:${baseurl}/Valuables")
        val request = scrapper.Soup("${baseurl}/Valuables")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
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
        return OtherItemsModel( items = items)
    }

    fun magicalItems(): OtherItemsModel {
        println("url_:${baseurl}/Magical_Items")
        val request = scrapper.Soup("${baseurl}/Magical_Items")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                attributes = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherItemsModel( items = items)
    }

    fun metals(): OtherItemsModel {
        println("url_:${baseurl}/Metals")
        val request = scrapper.Soup("${baseurl}/Metals")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                attributes = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherItemsModel( items = items)
    }

    fun partyItems(): OtherItemsModel {
        println("url_:${baseurl}/Party_Items")
        val request = scrapper.Soup("${baseurl}/Party_Items")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                attributes = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherItemsModel( items = items)
    }

    fun blessingsCharms(): OtherItemsModel {
        println("url_:${baseurl}/Blessing_Charms")
        val request = scrapper.Soup("${baseurl}/Blessing_Charms")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                attributes = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherItemsModel( items = items)
    }

    fun questItems(): OtherItemsModel {
        println("url_:${baseurl}/Quest_Items")
        val request = scrapper.Soup("${baseurl}/Quest_Items")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                pickupable = tr[2].select("span").attr("title")
                attributes = tr[3].text().ifEmpty { null }
                weight = tr[4].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherItemsModel( items = items)
    }

    fun rubbish(): OtherItemsModel {
        println("url_:${baseurl}/Rubbish")
        val request = scrapper.Soup("${baseurl}/Rubbish")
        val items = ArrayList<OtherItems>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = OtherItems().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                pickupable = tr[2].select("span").attr("title")
                attributes = tr[3].text().ifEmpty { null }
                weight = tr[4].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherItemsModel( items = items)
    }

    fun runes(): RunesItemsList {
        println("url_:${baseurl}/Runes")
        val request = scrapper.Soup("${baseurl}/Runes")
        val items = ArrayList<RunesItem>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = RunesItem().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                type = tr[2].select("span").attr("title")
                level = tr[3].text().ifEmpty { null }
                magicLevel = tr[4].text().ifEmpty { null }
                npcPrice = tr[5].text().ifEmpty { null }
                weight = tr[6].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return RunesItemsList( items = items)
    }
}