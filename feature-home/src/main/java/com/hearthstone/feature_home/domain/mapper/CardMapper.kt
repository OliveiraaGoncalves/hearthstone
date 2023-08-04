package com.hearthstone.feature_home.domain.mapper

import com.hearthstone.feature_home.data.model.CardResponse
import com.hearthstone.feature_home.domain.model.Card

interface CardMapper {
    fun mapToCardBack(response: CardResponse): Card
}

class CardMapperImpl : CardMapper {
    override fun mapToCardBack(response: CardResponse): Card {
        return Card(
            cardId = response.cardId,
            dbfId = response.dbfId,
            name = response.name,
            cardSet = response.cardSet,
            type = response.type,
            faction = response.faction,
            text = response.text,
            playerClass = response.playerClass,
            locale = response.locale,
            rarity = response.rarity,
            cost = response.cost,
            attack = response.attack,
            health = response.health,
            flavor = response.flavor,
            img = response.img
        )
    }
}