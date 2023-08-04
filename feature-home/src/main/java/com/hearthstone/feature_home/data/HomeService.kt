package com.hearthstone.feature_home.data

import com.hearthstone.core_networking.handleProvider.NetworkResponse
import com.hearthstone.feature_home.data.model.CardResponse
import com.hearthstone.feature_home.data.model.CardSetResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeService {

    @GET("cards")
    suspend fun getCards(@Query("locale") locale: String = "ptBR"): NetworkResponse<CardSetResponse>

    @GET("cards/search/{name}")
    suspend fun findByCards(@Path("name") name: String, @Query("locale") locale: String = "ptBR", @Query("collectible") collectible: Int = 1): NetworkResponse<List<CardResponse>>
}