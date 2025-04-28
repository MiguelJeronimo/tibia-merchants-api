package com.miguel.tibia_merchants_api.data.network.tibia.Items

import Jsoup.Scrapper
import org.apache.logging.log4j.LogManager

class ItemProfile(scrapper: Scrapper, baseurl: String, name: String) {
    private val logger = LogManager.getLogger(ItemProfile::class.java)
    private val url = "${baseurl}/${name}"
    private val request = scrapper.Soup(url)
    fun item(){
        logger.info("url final: $url")
        val npcNotes = request.getElementById("npc-notes")
        val nameNPC = request.getElementsByClass("mw-page-title-main").text()
        val imgNPC = request.getElementById("twbox-image")?.select("img")
        //val mapImage = request.getElementsByClass("map_image").select("img").attr("src")
        logger.info(nameNPC)
        logger.info("Notes: $npcNotes")
        logger.info("img: $imgNPC")
    }
}