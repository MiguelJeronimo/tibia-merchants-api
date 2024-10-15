package com.miguel.tibia_merchants_api.data.network.tibia.Items.ohters

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.OtherModel
import com.miguel.tibia_merchants_api.domain.models.Others

class Other (val scrapper: Scrapper, private val baseurl: String){
    fun creatureProducts(): OtherModel {
        println("url_:${baseurl}/Creature_Products")
        val request = scrapper.Soup("${baseurl}/Creature_Products")
        val items = ArrayList<Others>()
        val tbody = request.getElementsByClass("wikitable sortable").select("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Others().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[2].text().ifEmpty { null }
                price = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherModel( items = items)
    }

    fun food(): OtherModel {
        println("url_:${baseurl}/Food")
        val request = scrapper.Soup("${baseurl}/Food")
        val items = ArrayList<Others>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Others().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[2].text().ifEmpty { null }
                price = tr[3].text().ifEmpty { null }
                stackable = tr[4].select("span ").attr("title").ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherModel( items = items)
    }

    fun liquids(): OtherModel {
        println("url_:${baseurl}/Liquids")
        val request = scrapper.Soup("${baseurl}/Liquids")
        val items = ArrayList<Others>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Others().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                attributes = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherModel( items = items)
    }

    fun plantsAndHerbs(): OtherModel {
        println("url_:${baseurl}/Plants_and_Herbs")
        val request = scrapper.Soup("${baseurl}/Plants_and_Herbs")
        val items = ArrayList<Others>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody")
        tbody.select("tr").forEach {
            val tr = it.children()
            val item = Others().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                attributes = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            items.add(item)
        }
        items.removeFirst()
        return OtherModel( items = items)
    }
}