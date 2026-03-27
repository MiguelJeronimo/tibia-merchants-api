package com.miguel.tibia_merchants_api.domain.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class WikiModels(
    val parse: ParseInfo? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ParseInfo(
    val title: String? = null,
    @JsonProperty("pageid")
    val pageId: Int? = null,
    val text: ContentText? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ContentText(
    @JsonProperty("*")
    val content: String? = null
)