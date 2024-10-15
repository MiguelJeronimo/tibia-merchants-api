package com.miguel.tibia_merchants_api.data.network.tibia.Items.bodyequipment

import Jsoup.Scrapper
import model.Tibia.BodyEquipment
import model.Tibia.ItemEquipment
import org.jsoup.select.Elements

class EquipmentList(scrapper: Scrapper, baseurl: String, val name: String) {
    private val url = "${baseurl}/${name}"
    private val request = scrapper.Soup(url)
    private var container: Elements? = null
    fun item(): ArrayList<ItemEquipment> {
        println("url_: $url")
        val bodyEquipment = BodyEquipment()
        val items = ArrayList<ItemEquipment>()
        request.getElementsByClass("wikitable sortable full-width").also {
            if (it.isEmpty()){
                container = request.getElementsByClass("wikitable full-width sortable")
            } else {
                container = it
            }
        }
        val tbody = container?.select("tbody")
        val tr = tbody?.select("tr")
        val list = when (name.lowercase()){
            "quivers"-> quevers(tr, items)
            "spellbooks"-> spellBooks(tr,items)
            else-> itemsEquipments(tr,items)
        }
        return list.also { bodyEquipment.items = it }
    }

    private fun quevers(tr: Elements?, items: ArrayList<ItemEquipment>): ArrayList<ItemEquipment> {
        tr?.forEach {
            val data = it.children()
            val item = ItemEquipment().apply {
                name = data[0].text()
                img = data[1].select("img").attr("data-src")
                vol = data[2].text()
                weight = data[3].text()
                data[4].text().also { lvl->
                    level = lvl.ifEmpty{null}
                }
                data[5].text().also { att->
                    attributes = att.ifEmpty { null }
                }
            }
            items.add(item)
        }
        items.removeFirst()
        return items
    }

    private fun spellBooks(tr: Elements?, items: ArrayList<ItemEquipment>): ArrayList<ItemEquipment> {
        tr?.forEach {
            val data = it.children()
            val item = ItemEquipment().apply {
                name = data[0].text()
                val image = data[0].select("img").attr("data-src")
                if (image == ""){
                    img = data[1].select("img").attr("data-src")
                    level = data[2].text()
                    vocation = data[3].text()
                    data[4].text().also { att->
                        defense = att.ifEmpty { null }
                    }
                    attributes = data[5].text()
                    resist =data[6].text()
                    data[7].text().also { lvl->
                        slots = lvl.ifEmpty{null}
                    }
                    weight = data[8].text()
                } else {
                    img = image
                    arm = data[1].text()
                    weight = data[2].text()
                    data[3].text().also { att->
                        attributes = att.ifEmpty { null }
                    }
                    resist = data[4].text()
                    slots =data[5].text()
                    classs = data[6].text()
                    data[7].text().also { lvl->
                        level = lvl.ifEmpty{null}
                    }
                    vocation = data[8].text()
                }
            }
            items.add(item)
        }
        items.removeFirst()
        return items
    }

    private fun itemsEquipments(tr: Elements?, items: ArrayList<ItemEquipment>): ArrayList<ItemEquipment> {
        tr?.forEach {
            val data = it.children()
            val item = ItemEquipment().apply {
                name = data[0].text()
                val image = data[0].select("img").attr("data-src")
                if (image == ""){
                    img = data[1].select("img").attr("data-src")
                    defense = data[2].text()
                    weight = data[3].text()
                    data[4].text().also { att->
                        attributes = att.ifEmpty { null }
                    }
                    resist = data[5].text()
                    slots =data[6].text()
                    data[7].text().also { lvl->
                        level = lvl.ifEmpty{null}
                    }
                    vocation = data[8].text()
                } else {
                    img = image
                    arm = data[1].text()
                    weight = data[2].text()
                    data[3].text().also { att->
                        attributes = att.ifEmpty { null }
                    }
                    resist = data[4].text()
                    slots = data[5].text()
                    classs = data[6].text()
                    data[7].text().also { lvl->
                        level = lvl.ifEmpty{null}
                    }
                    vocation = data[8].text()
                }
            }
            items.add(item)
        }
        items.removeFirst()
        return items
    }
}