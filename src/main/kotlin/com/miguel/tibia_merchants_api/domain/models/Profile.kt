package com.miguel.tibia_merchants_api.domain.models

data class Profile(
    var name: String? = null,
    var img: String? = null,
    var notes: String? = null,
    var requeriments: Requeriments? = null,
    var combat_propierties: CombatPropierties? = null,
    var general_propierties: GeneralPropierties? = null,
    var trader_propierties: TraderPropierties? = null,
    var field_propierties: FieldPropierties? = null,
    var other_propierties: OtherPropierties? = null
)

data class Requeriments(
    var level: String? = null,
    var vocation: String? = null
)

data class CombatPropierties(
    var imbuing_slots: String? = null,
    var upgrade_classification: String? = null,
    var attributes: String? = null,
    var armor: String? = null,
    var resists: String? = null
)

data class GeneralPropierties(
    var classification: String? = null,
    var pickupable: String? = null,
    var weight: String? = null,
    var stackable: String? = null,
)

data class TraderPropierties(
    var marketable: String? = null,
    var value: String? = null,
    var sold_for: String? = null,
    var bought_for: String? = null,
)

data class FieldPropierties(
    var blocking: String? = null
)

data class OtherPropierties(
    var version: String? = null
)

data class Sections(
    var key: String? = null,
    var value: String? = null
)