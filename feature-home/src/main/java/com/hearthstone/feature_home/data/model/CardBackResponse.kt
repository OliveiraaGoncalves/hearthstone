package com.hearthstone.feature_home.data.model

data class CardBackResponse(
    val cardBackId: Int,

    val name: String,

    val description: String?,

    val source: String,

    val enabled: Boolean,

    val img: String?,

    val imgAnimated: String?,

    val sortCategory: Int,

    val sortOrder: Int,

    val locale: String,
)