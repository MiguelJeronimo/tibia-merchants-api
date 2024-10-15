package com.miguel.tibia_merchants_api.data.network.tibia.householdItems

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.HoldHouse
import com.miguel.tibia_merchants_api.domain.models.HoldHouseItems

class HouseholdItems(val scrapper: Scrapper, private val baseurl: String) {

    fun books(): HoldHouseItems {
        println("url_:${baseurl}/Books")
        val request = scrapper.Soup("${baseurl}/Books")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun carpets(): HoldHouseItems {
        println("url_:${baseurl}/Containers")
        val request = scrapper.Soup("${baseurl}/Containers")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                price = tr[3].text().ifEmpty { null }
                weight = tr[4].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun containers(): HoldHouseItems {
        println("url_:${baseurl}/Containers")
        val request = scrapper.Soup("${baseurl}/Containers")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                slots = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
                vol = tr[4].text().ifEmpty { null }
                weightPerVol = tr[5].text().ifEmpty { null }
                buyFrom = tr[7].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun contestPrizes(): HoldHouseItems {
        println("url_:${baseurl}/Contest_Prizes")
        val request = scrapper.Soup("${baseurl}/Contest_Prizes")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun fanSiteItems(): HoldHouseItems {
        println("url_:${baseurl}/Fansite_Items")
        val request = scrapper.Soup("${baseurl}/Fansite_Items")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                light = tr[3].text().ifEmpty { null }
                writable = tr[4].select("span").attr("title")
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun decorations(): HoldHouseItems {
        println("url_:${baseurl}/Decorations")
        val request = scrapper.Soup("${baseurl}/Decorations")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun documentsAndPapers(): HoldHouseItems {
        println("url_:${baseurl}/Documents_and_Papers")
        val request = scrapper.Soup("${baseurl}/Documents_and_Papers")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun dollsAndBears(): HoldHouseItems {
        println("url_:${baseurl}/Dolls_and_Bears")
        val request = scrapper.Soup("${baseurl}/Dolls_and_Bears")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun furniture(): HoldHouseItems {
        println("url_:${baseurl}/Furniture")
        val request = scrapper.Soup("${baseurl}/Furniture")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("sortable wikitable").select("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                vol = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
                buyFrom = tr[4].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun kitchenTools(): HoldHouseItems {
        println("url_:${baseurl}/Kitchen_Tools")
        val request = scrapper.Soup("${baseurl}/Kitchen_Tools")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun musicalInstruments(): HoldHouseItems {
        println("url_:${baseurl}/Musical_Instruments")
        val request = scrapper.Soup("${baseurl}/Musical_Instruments")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[2].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }

    fun trophies(): HoldHouseItems {
        println("url_:${baseurl}/Trophies")
        val request = scrapper.Soup("${baseurl}/Trophies")
        val items = ArrayList<HoldHouse>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = HoldHouse().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return HoldHouseItems( items = items)
    }
}