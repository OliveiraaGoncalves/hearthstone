package com.hearthstone.feature_home.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
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
) : Parcelable

@Parcelize
data class CardSet(
    val basic: List<Card>,
) : Parcelable
