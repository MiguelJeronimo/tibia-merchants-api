package com.miguel.tibia_merchants_api.data.repositories.wikipediaapi

import com.miguel.tibia_merchants_api.domain.models.WikiModels
import com.miguel.tibia_merchants_api.utils.exceptions.ResourceNotFoundException
import org.apache.logging.log4j.LogManager
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity


class RepositoryWikiTibiaImpl: RepositoryWikiTibia {
    private val response = RestTemplate()
    private val logger = LogManager.getLogger()
    override suspend fun getWikiContent(title: String): WikiModels {
        return try {
            val url = "https://tibia.fandom.com/api.php?action=parse&page=$title&prop=text&format=json"
            val response = response.getForEntity<WikiModels>(url)
            
            if (response.statusCode.isError){
                throw ResourceNotFoundException("Wiki content not found for: $title")
            }
            response.body ?: throw ResourceNotFoundException("Empty body for: $title")
        } catch (e:Exception) {
            logger.error("Error fetching wiki content for $title: ${e.message}")
            throw ResourceNotFoundException("Fail to get wiki info for: $title")
        }
    }
}