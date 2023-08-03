package com.hearthstone.feature_home.data

import com.hearthstone.core_networking.handleProvider.toFlow
import com.hearthstone.feature_home.data.model.CardBackResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface CardBackRepository {
    suspend fun getCardBacksItems(): Flow<List<CardBackResponse>>
}

class CardBackRepositoryImpl(
    private val cardbackService: CardbackService
) : CardBackRepository {
    override suspend fun getCardBacksItems(): Flow<List<CardBackResponse>> {
        return cardbackService.getCards().toFlow().map {
            it
        }
    }
}