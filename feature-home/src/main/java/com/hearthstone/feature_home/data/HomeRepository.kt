package com.hearthstone.feature_home.data

import com.hearthstone.core_networking.handleProvider.toFlow
import com.hearthstone.feature_home.data.model.CardResponse
import com.hearthstone.feature_home.data.model.CardSetResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface HomeRepository {
    suspend fun getCardItems(): Flow<CardSetResponse>
    suspend fun getCard(name: String): Flow<List<CardResponse>>
}

class HomeRepositoryImpl(
    private val homeService: HomeService
) : HomeRepository {
    override suspend fun getCardItems(): Flow<CardSetResponse> =
        homeService.getCards().toFlow().map {
            it
        }

    override suspend fun getCard(name: String): Flow<List<CardResponse>> =
        homeService.findByCards(name = name).toFlow().map { it }
}