package com.hearthstone.feature_home.domain

import com.hearthstone.feature_home.data.HomeRepository
import com.hearthstone.feature_home.domain.mapper.CardMapper
import com.hearthstone.feature_home.domain.model.Card
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface CardBackUseCase {
    suspend fun getCardItems(): Flow<List<Card>>
    suspend fun getCard(name: String): Flow<Card>
}

class CardBackUseCaseImpl(
    private val repository: HomeRepository,
    private val mapper: CardMapper,
) : CardBackUseCase {
    override suspend fun getCardItems(): Flow<List<Card>> =
        repository.getCardItems().map { cardSetResponse ->
            cardSetResponse.basic.map {
                mapper.mapToCardBack(it)
            }
        }

    override suspend fun getCard(name: String): Flow<Card> =
        repository.getCard(name).map { cardResponse ->
            cardResponse.map {
                mapper.mapToCardBack(it)
            }.first()
        }
}