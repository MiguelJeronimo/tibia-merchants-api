package com.miguel.tibia_merchants_api.data.network.tibia

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.Item
import com.miguel.tibia_merchants_api.domain.models.Spells
import com.miguel.tibia_merchants_api.domain.models.npc.NPCInfo
import com.miguel.tibia_merchants_api.domain.models.npc.NameNPC
import org.apache.logging.log4j.LogManager
import org.jsoup.nodes.Document


class NPCProfile(private val scrapper: Scrapper, private val baseurl: String) {
    val arrayBuyingItems = ArrayList<Item>()
    val arraSellingItems = ArrayList<Item>()
    val arraySellingSpells = ArrayList<Spells>()
    val item = Item(null, null, null)
    val spells = Spells(null, null, null, null, null)
    private val logger = LogManager.getLogger(NPCProfile::class.java)

    fun information(name:String): NPCInfo {
        logger.info("URL Wiki: \"${baseurl}/${name}\"")
        val arrayCitys = ArrayList<NameNPC>()
        val request = scrapper.Soup("${baseurl}/${name}")
        val npcNotes = request.getElementById("npc-notes")!!.text()
        val nameNPC = request.getElementsByClass("mw-page-title-main").text()
        val imgNPC = request.getElementById("twbox-image")?.select("img")?.attr("src")
        val aside = request.getElementsByClass("portable-infobox pi-background pi-border-color pi-theme-twbox pi-layout-default")
        val gender = aside.select("[data-source=\"gender\"]").select("[class=\"pi-data-value pi-font\"]").text()
        val race = aside.select("[data-source=\"race\"]").select("[class=\"pi-data-value pi-font\"]").text()
        val job = aside.select("[data-source=\"job\"]").select("[class=\"pi-data-value pi-font\"]").text()
        val version = aside.select("[data-source=\"implemented\"]").select("[class=\"pi-data-value pi-font\"]").text()
        val status = aside.select("[data-source=\"status\"]").select("[class=\"pi-data-value pi-font\"]").text()
        val city = aside.select("[class=\"wds-tab__content wds-is-current\"]")
        val citys = aside.select("[class=\"wds-tab__content\"]")

        city.forEach {
            arrayCitys.add(
                NameNPC(
                    name = it.getElementsByClass("pi-data-value pi-font").text(),
                    map= it.getElementsByClass("map_image").select("img").attr("src")
                )
            )
        }
        if (citys.toString() != ""){
            citys.forEach {
                arrayCitys.add(
                    NameNPC(
                        name = it.getElementsByClass("pi-data-value pi-font").text(),
                        map= it.getElementsByClass("map_image").select("img").attr("src")
                    )
                )
            }
        }
        return NPCInfo().apply {
            this.name = nameNPC
            this.imgNPC = imgNPC
            this.citys = arrayCitys
            this.description = npcNotes
            this.gender = gender
            this.race = race
            this.job = job
            this.version = version
            this.status = status
            this.buyingItems = getBuyingItems(request)
            this.sellingItems = getSellingItems(request)
        }
    }

    private fun getBuyingItems(document: Document): ArrayList<Item>? {
        val tableBuys = document.getElementById("npc-trade-buys")
        val tbody = tableBuys?.select("tbody")//?.select("tr")
        return if (tableBuys != null) {
            if (tbody.toString() != "") {
                val trBuys = tbody?.select("tr")
                trBuys?.forEach {
                    val img = it.select("a").select("img")
                    if (img.isNotEmpty()) {
                        val price = it.select("[style=white-space:nowrap]").text()
                        item.price = price
                        val nameItem = it.select("a").attr("title")
                        if (img.attr("data-src") == "") {
                            item.name = nameItem
                            item.img = img.attr("src")
                        } else {
                            item.name = nameItem
                            item.img = img.attr("data-src")
                        }
                        arrayBuyingItems.add(
                            Item(
                                item.name,
                                item.img,
                                item.price
                            )
                        )
                    }
                }
                arrayBuyingItems
            } else {
                null
            }
        } else {
            null
        }
    }

    private fun getSellingItems(document: Document): ArrayList<Item>? {
        val tableSells = document.getElementById("npc-trade-sells")
        val tbody = tableSells?.select("tbody")//?.select("tr")
        return if (tableSells != null) {
            if (tbody.toString() != "") {
                val trSells = tbody?.select("tr")
                trSells?.forEach {
                    val img = it.select("a").select("img")
                    if (img.isNotEmpty()) {
                        val price = it.select("[style=white-space:nowrap]").text()
                        item.price = price
                        val nameItem = it.select("a").attr("title")
                        if (img.attr("data-src") == "") {
                            item.name = nameItem
                            item.img = img.attr("src")
                        } else {
                            item.name = nameItem
                            item.img = img.attr("data-src")
                        }
                        arraSellingItems.add(
                            Item(
                                item.name,
                                item.img,
                                item.price
                            )
                        )
                    }
                }
                arraSellingItems
            } else {
                null
            }
        } else {
            null
        }
    }
}