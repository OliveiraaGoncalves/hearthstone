package com.hearthstone.feature_home.domain

import com.hearthstone.feature_home.data.CardBackRepository
import com.hearthstone.feature_home.domain.mapper.CardBackMapper
import com.hearthstone.feature_home.domain.model.Cardback
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface CardBackUseCase {
    suspend fun getCardBacksItems(): Flow<List<Cardback>>
}

class CardBackUseCaseImpl(
    private val repository: CardBackRepository,
    private val mapper: CardBackMapper,
) : CardBackUseCase {
    override suspend fun getCardBacksItems(): Flow<List<Cardback>> =
        repository.getCardBacksItems().map { cardBackResponses ->
            cardBackResponses.map {
                mapper.mapToCardBack(it)
            }
        }
}