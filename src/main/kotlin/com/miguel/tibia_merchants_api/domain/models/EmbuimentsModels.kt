package com.miguel.tibia_merchants_api.domain.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Imbuements(
    var embuiments: ArrayList<EmbuimentsAttributes>?=null
)

data class EmbuimentsAttributes(
    var name: String?=null,
    var img: String?=null,
    var attributes: Attributes?=null

)
data class Attributes(
    var basic: Basic?=null,
    var intricate: Intricate?=null,
    @JsonProperty("power_full")
    var powerFull: PowerFull?=null
)

data class Basic(
    var name:String?=null,
    var percent: String?=null,
    var critical: Critical?=null,
    @JsonProperty("items_requirements")
    var itemsRequirements:String?=null,
    @JsonProperty("available_for")
    var availableFor:String?= null,
    var img:String? = null
)

data class Intricate(
    var name:String?=null,
    var percent: String?=null,
    var critical: Critical?=null,
    @JsonProperty("items_requirements")
    var itemsRequirements:String?=null,
    @JsonProperty("available_for")
    var availableFor:String?= null,
    var img:String? = null
)

data class PowerFull(
    var name:String?=null,
    var percent: String?=null,
    var critical: Critical?=null,
    @JsonProperty("items_requirements")
    var itemsRequirements:String?=null,
    @JsonProperty("available_for")
    var availableFor:String?= null,
    var img:String? = null
)

data class Critical(
    @JsonProperty("extra_change")
    val extraChange:String,
    @JsonProperty("critical_Damage_increased_by")
    val criticalDamageIncreasedBy: String
)