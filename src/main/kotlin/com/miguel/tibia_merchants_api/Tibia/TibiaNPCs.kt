package com.miguel.tibia_merchants_api.Tibia

import API.Tibia.NPCs
import Jsoup.Scrapper
import model.Tibia.Rashid
import model.Tibia.Yasir

class TibiaNPCs(scrapper: Scrapper, url: String): NPCs(scrapper, url){

    fun rashid(): Rashid {
        val rashid = Rashid(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
        )
        val aside = scrap.getElementsByClass("portable-infobox pi-background pi-border-color pi-theme-twbox pi-layout-default")
        val city = aside.select("[class=\"pi-data-value pi-font\"]").eachText()[0]
        rashid.map = mapImage
        rashid.description = scrap.getElementById("npc-notes")?.text()
        rashid.imgNPC = imgNPC
        rashid.nameNPC = nameNPC
        rashid.nearestCity = city
        rashid.gender = data[7]
        rashid.race = data[8]
        rashid.job = data[9]
        rashid.version = data[10]
        rashid.status = data[11]
        rashid.items = getBuyingItems()
        return rashid
    }

    fun yasir(): Yasir {
        val aside = scrap.getElementsByClass("portable-infobox pi-background pi-border-color pi-theme-twbox pi-layout-default")
        val city = aside.select("[class=\"pi-data-value pi-font\"]").eachText()[0]
        val yasir = Yasir(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
        )
        yasir.map = mapImage
        yasir.description = scrap.getElementById("npc-notes")?.text()
        yasir.imgNPC = imgNPC
        yasir.nameNPC = nameNPC
        yasir.nearestCity = city
        yasir.gender = data[3]
        yasir.race = data[4]
        yasir.job = data[5]
        yasir.version = data[5]
        yasir.status = data[6]
        yasir.items = getBuyingItems()
        return yasir
    }
}