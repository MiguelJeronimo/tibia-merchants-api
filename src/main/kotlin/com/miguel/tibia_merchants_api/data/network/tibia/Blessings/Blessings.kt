package Tibia.Blessings

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.domain.models.Blessing
import com.miguel.tibia_merchants_api.domain.models.Blessings

class Blessings(val scrapper: Scrapper, baseurl: String) {
    private val url = "${baseurl}/Blessings"
    private val request = scrapper.Soup(url)

    fun blessingsInformation(): ArrayList<Blessings> {
        println(url)
        val container = request.select("[class=\"wikitable\"]")
        val introduction = request.select("h2 + p").first()!!.text()+
                request.select("h2 + p + p").first()!!.text() +
                "${request.select("h2 + p +p + ol").first()?.text()} "
        val blesingsCharmsTable = container[0].select("tbody")
        val array = ArrayList<Blessings>()
        blesingsCharmsTable.select("tr").forEach {
            val th = it.children()
            val blessing = Blessings().apply {
                name = th[0].text()
                npc_location = th[1].text()
                img = th[2].select("img").attr("data-src")
                store_price = th[3].text()
                aditional_info = th[4].text()
                premium = th[5].select("span").attr("title")
            }
            array.add(blessing)
        }
        array.removeFirst()
        return array
    }
}