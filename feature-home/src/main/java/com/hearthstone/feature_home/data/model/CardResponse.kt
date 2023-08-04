package com.hearthstone.feature_home.data.model

import com.squareup.moshi.Json

data class CardResponse(
    val cardId: String,
    val dbfId: Int,
    val name: String,
    val cardSet: String,
    val type: String,
    val faction: String?,
    val text: String?,
    val playerClass: String,
    val locale: String,
    val rarity: String?,
    val cost: String?,
    val attack: String?,
    val health: String?,
    val flavor: String?,
    val img: String?,
)

data class CardSetResponse(
    @Json(name = "Basic") val basic: List<CardResponse>
)