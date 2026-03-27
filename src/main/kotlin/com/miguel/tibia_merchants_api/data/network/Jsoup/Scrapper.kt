package Jsoup

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class Scrapper {
    fun Soup(url: String): Document {
        return Jsoup.connect(url).get()
    }

    fun htmlConverter(code: String): Document {
        return Jsoup.parse(code)
    }
}