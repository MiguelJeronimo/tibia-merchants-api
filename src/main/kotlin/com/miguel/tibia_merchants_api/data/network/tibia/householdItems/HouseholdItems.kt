package com.miguel.tibia_merchants_api.data.network.tibia.householdItems

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.HoldHouse
import com.miguel.tibia_merchants_api.domain.models.HoldHouseItems

class HouseholdItems(val scrapper: Scrapper, private val html: String) {

    private val request = scrapper.htmlConverter(html)

    fun books(): HoldHouseItems {
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