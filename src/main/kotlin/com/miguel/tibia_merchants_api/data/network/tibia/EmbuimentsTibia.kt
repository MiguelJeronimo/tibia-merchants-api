package com.miguel.tibia_merchants_api.data.network.tibia

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.Attributes
import com.miguel.tibia_merchants_api.domain.models.Basic
import com.miguel.tibia_merchants_api.domain.models.Critical
import com.miguel.tibia_merchants_api.domain.models.EmbuimentsAttributes
import com.miguel.tibia_merchants_api.domain.models.Imbuements
import com.miguel.tibia_merchants_api.domain.models.Intricate
import com.miguel.tibia_merchants_api.domain.models.PowerFull
import org.jsoup.select.Elements

class EmbuimentsTibia(scrapper: Scrapper, baseURL:  String) {
    private val url = "${baseURL}/Imbuing"
    private val request = scrapper.Soup(url)
    private val model = Imbuements()
    private val modelList = ArrayList<EmbuimentsAttributes>()

    fun embuiments(): Imbuements {
        val nodes = request.getElementById("content")?.children()
        walkTree(nodes =  nodes, list = modelList)
        val list = modelList.distinctBy { it.name }
        return model.apply { this.embuiments = list as ArrayList}
    }

    fun walkTree(nodes: Elements?, list: ArrayList<EmbuimentsAttributes>, map: HashMap<String, String> = HashMap()){
        for (node in nodes!!){
            when{
                node.tagName() == "h4"->{
                    if (node.child(0).text() != "References"){
                        map["name"] = node.child(0).text()
                    }
                }
                node.tagName() == "figure" && node.className() == "mw-default-size mw-halign-left"->{
                    map["img"] = node.select("img").attr("data-src")
                }
                node.className() == "wikitable sortable"->{
                    val tbody = node.children()
                    val tr = tbody.select("tr").first()?.select("th")?.first()
                    if (tr?.text() == "Imbuement Name"){
                        tbody?.let {
                            tableEmbuiments(it, list = list, map)
                        }
                    }
                }
                else-> walkTree(node.children(),list, map)
            }
        }
    }

    fun tableEmbuiments(tBody: Elements, list: ArrayList<EmbuimentsAttributes>, map: HashMap<String, String>){
        val attributes = Attributes()
        val trs = tBody.select("tr")
        trs.forEach {
            val tds = it.select("td")
            if (tds.size>0){
                if (tds.size == 6){
                    when{
                        tds[0].text().contains("Basic")->{
                            attributes.basic = Basic().apply {
                                name = tds[0].text()
                                critical = Critical(
                                    extraChange = tds[1].text(),
                                    criticalDamageIncreasedBy = tds[2].text()
                                )
                                itemsRequirements = tds[3].text()
                                availableFor = tds[4].text()
                                img = tds[5].select("img").attr("data-src")
                            }
                        }
                        tds[0].text().contains("Intricate")->{
                            attributes.intricate = Intricate().apply {
                                name = tds[0].text()
                                critical = Critical(
                                    extraChange = tds[1].text(),
                                    criticalDamageIncreasedBy = tds[2].text()
                                )
                                itemsRequirements = tds[3].text()
                                availableFor = tds[4].text()
                                img = tds[5].select("img").attr("data-src")
                            }
                        }
                        tds[0].text().contains("Powerful")->{
                            attributes.powerFull = PowerFull().apply {
                                name = tds[0].text()
                                critical = Critical(
                                    extraChange = tds[1].text(),
                                    criticalDamageIncreasedBy = tds[2].text()
                                )
                                itemsRequirements = tds[3].text()
                                availableFor = tds[4].text()
                                img = tds[5].select("img").attr("data-src")
                            }
                        }
                    }
                } else {
                    when{
                        tds[0].text().contains("Basic")->{
                            attributes.basic = Basic().apply {
                                name = tds[0].text()
                                percent = tds[1].text()
                                itemsRequirements = tds[2].text()
                                availableFor = tds[3].text()
                                img = tds[4].select("img").attr("data-src")
                            }
                        }
                        tds[0].text().contains("Intricate")->{
                            attributes.intricate = Intricate().apply {
                                name = tds[0].text()
                                percent = tds[1].text()
                                itemsRequirements = tds[2].text()
                                availableFor = tds[3].text()
                                img = tds[4].select("img").attr("data-src")
                            }
                        }
                        tds[0].text().contains("Powerful")->{
                            attributes.powerFull = PowerFull().apply {
                                name = tds[0].text()
                                percent = tds[1].text()
                                itemsRequirements = tds[2].text()
                                availableFor = tds[3].text()
                                img = tds[4].select("img").attr("data-src")
                            }
                        }
                    }
                }
            }
            val embuiments = EmbuimentsAttributes().apply {
                this.name = map["name"]
                this.img = map["img"]
                this.attributes = attributes
            }
            list.add(embuiments)
        }
    }
}