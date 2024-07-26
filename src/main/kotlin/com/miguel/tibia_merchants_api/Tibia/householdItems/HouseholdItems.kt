package com.miguel.tibia_merchants_api.Tibia.householdItems

import Jsoup.Scrapper
import com.miguel.tibia_merchants_api.model.Tibia.Books
import com.miguel.tibia_merchants_api.model.Tibia.Book

class HouseholdItems(val scrapper: Scrapper, private val baseurl: String) {

    fun books(): Books {
        println("url_:${baseurl}/Books")
        val request = scrapper.Soup("${baseurl}/Books")
        val books = ArrayList<Book>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val book = Book().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            books.add(book)
        }
        books.removeFirst()
        return Books( books = books)
    }

    fun carpets(): Books {
        println("url_:${baseurl}/Containers")
        val request = scrapper.Soup("${baseurl}/Containers")
        val books = ArrayList<Book>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val book = Book().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                price = tr[3].text().ifEmpty { null }
                weight = tr[4].text().ifEmpty { null }
            }
            books.add(book)
        }
        books.removeFirst()
        return Books( books = books)
    }

    fun containers(): Books {
        println("url_:${baseurl}/Containers")
        val request = scrapper.Soup("${baseurl}/Containers")
        val books = ArrayList<Book>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val book = Book().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                slots = tr[2].text().ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
                vol = tr[4].text().ifEmpty { null }
                weightPerVol = tr[5].text().ifEmpty { null }
                buyFrom = tr[7].text().ifEmpty { null }
            }
            books.add(book)
        }
        books.removeFirst()
        return Books( books = books)
    }

    fun contestPrizes(): Books {
        println("url_:${baseurl}/Contest_Prizes")
        val request = scrapper.Soup("${baseurl}/Contest_Prizes")
        val books = ArrayList<Book>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val book = Book().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            books.add(book)
        }
        books.removeFirst()
        return Books( books = books)
    }

    fun fanSiteItems(): Books {
        println("url_:${baseurl}/Fansite_Items")
        val request = scrapper.Soup("${baseurl}/Fansite_Items")
        val books = ArrayList<Book>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val book = Book().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                light = tr[3].text().ifEmpty { null }
                writable = tr[4].select("span").attr("title")
            }
            books.add(book)
        }
        books.removeFirst()
        return Books( books = books)
    }

    fun decorations(): Books {
        println("url_:${baseurl}/Decorations")
        val request = scrapper.Soup("${baseurl}/Decorations")
        val books = ArrayList<Book>()
        val tbody = request.getElementsByClass("wikitable sortable full-width")
            .tagName("tbody").select("[class=\"wikitable sortable full-width\"]")
        tbody.select("tr").forEach {
            val tr = it.children()
            val book = Book().apply {
                name = tr[0].text().ifEmpty { null }
                img = tr[1].select("img").attr("data-src").ifEmpty { null }
                weight = tr[3].text().ifEmpty { null }
            }
            books.add(book)
        }
        books.removeFirst()
        return Books( books = books)
    }




}