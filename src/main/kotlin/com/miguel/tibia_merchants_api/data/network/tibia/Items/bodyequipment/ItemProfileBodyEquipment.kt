package com.miguel.tibia_merchants_api.data.network.tibia.Items.bodyequipment

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.*
import com.miguel.tibia_merchants_api.utils.Utils
import org.jsoup.select.Elements

class ItemProfileBodyEquipment (scrapper: Scrapper, baseurl: String, name: String){
    private val url = "${baseurl}/${name}"
    private val request = scrapper.Soup(url)
    private val utils = Utils()
    /**
     * Search the next data for items profile:
     * - Requeriments
     *      - level
     *      - vocation
     * - Combat Propierties
     *      - Imbuing Slots
     *      - Upgrade Classification
     *      - Attributes
     *      - Armor
     *      - Resists
     * - General Propierties
     *      - Classification
     *      - Pickupable
     *      - Weight
     *      - Stackable
     * - Trader propierties
     *      - Marketable
     *      - Value
     *      - Sold for
     *      - Bought for
     * - Field Propierties
     *      - Blocking
     * - Other propierties
     *      - Version
     *
     * **/
    fun item(): Profile {
        println("url final: $url")
        val buy = ArrayList<BuyFrom>()
        val sell = ArrayList<SellFrom>()
        val npcNotes = request.getElementById("object-notes")?.children()
        val history = request.getElementById("object-history")?.children()
        val tibia = request.getElementById("twbox-look")?.text()
        val nameNPC = request.getElementsByClass("mw-page-title-main").text()
        val imgNPC = request.getElementById("twbox-image")
            ?.select("img")?.attr("src")
        //val mapImage = request.getElementsByClass("map_image").select("img").attr("src")
        val aside = request.getElementsByClass(
            "portable-infobox pi-background pi-border-color pi-theme-twbox pi-layout-default"
        )

        val trades = request.getElementsByClass("trades")
        val section = aside.select("section")
        val requeriment = utils.addDataInClass(
            section(section, "Requirements").ifEmpty { null },
            Requeriments()
        )

        val combat = utils.addDataInClass(
            section(section, "Combat Properties").ifEmpty { null },
            CombatPropierties()
        )

        val general = utils.addDataInClass(
            section(section, "General Properties").ifEmpty { null },
            GeneralPropierties()
        )

        val trade = utils.addDataInClass(
            section(section, "Trade Properties").ifEmpty { null },
            TraderPropierties()
        )

        val field = utils.addDataInClass(
            section(section, "Field Properties").ifEmpty { null },
            FieldPropierties())

        val other = utils.addDataInClass(
            section(section, "Other Properties").ifEmpty { null },
            OtherPropierties()
        )

        val magicPropierties = utils.addDataInClass(
            section(section, "Magic Properties").ifEmpty { null },
            MagicProperties()
        )

        var note = ""
        npcNotes?.forEach {
            if (it.text() != "Notes"){
                note += "${it.text()}\n"
            }
        }
        history?.forEach {
            if (it.text() != "History"){
                note += "${it.text()}\n"
            }
        }

        trades[0].select("tbody").forEach {
            val tr = it.select("[style=\"text-align:center\"]")
            tr.forEach {
                val td = it.children()
                val buyFrom = BuyFrom().apply {
                    if (td[0].text() != "NPC"){
                        npc = td[0].children()[0].text()
                        location = td[1].text()
                        price = td[2].text()
                    }
                }
                buy.add(buyFrom)
            }
        }

        trades[1].select("tbody").forEach {
            val tr = it.select("[style=\"text-align:center\"]")
            tr.forEach {
                val td = it.children()
                val sellFrom = SellFrom().apply {
                    if (td[0].text() != "NPC"){
                        npc = td[0].children()[0].text()
                        location = td[1].text()
                        price = td[2].text()
                    }
                }
                sell.add(sellFrom)
            }
        }

        return Profile().apply {
            name = nameNPC
            img = imgNPC
            tibia_lengend = tibia.toString().ifEmpty { null }
            notes = note
            requeriments = requeriment as Requeriments?
            combat_propierties = combat as CombatPropierties?
            general_propierties = general as GeneralPropierties?
            trader_propierties = trade as TraderPropierties?
            field_propierties = field as FieldPropierties?
            other_propierties = other as OtherPropierties?
            magic_properties = magicPropierties as MagicProperties?
            buy_from = buy.ifEmpty { null }
            sell_from = sell.ifEmpty { null }

        }
    }

    private fun section(section: Elements, title: String): ArrayList<Sections> {
        val array = ArrayList<Sections>()
        section.forEach {
            val children = it.children()
            var nextElements: Elements?
            children.forEach {
                if (it.tagName() == "h2"){
                    if (it.text() == title){
                        nextElements = it.nextElementSiblings()
                        nextElements!!.forEach {
                            val child = it.children()
                            val sectionsClass = Sections().apply {
                                key = child[0].text().lowercase().replace(" ","_")
                                value = child[1].text().ifEmpty { null }!!
                            }
                            array.add(sectionsClass)
                        }
                    }
                }
            }
        }
        return array
    }
}