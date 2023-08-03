package com.hearthstone.feature_home.data

import com.hearthstone.core_networking.handleProvider.NetworkResponse
import com.hearthstone.feature_home.data.model.CardBackResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CardbackService {

    @GET("cardbacks")
    suspend fun getCards(@Query("locale") locale: String = "ptBR") : NetworkResponse<List<CardBackResponse>>
}