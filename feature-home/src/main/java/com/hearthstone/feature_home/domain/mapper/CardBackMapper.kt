package com.hearthstone.feature_home.domain.mapper

import com.hearthstone.feature_home.data.model.CardBackResponse
import com.hearthstone.feature_home.domain.model.Cardback
import dev.krud.shapeshift.ShapeShift
import dev.krud.shapeshift.ShapeShiftBuilder
import org.modelmapper.ModelMapper

interface CardBackMapper {
    fun mapToCardBack(response: CardBackResponse): Cardback
}

class CardBackMapperImpl : CardBackMapper {
    override fun mapToCardBack(response: CardBackResponse): Cardback {
        return Cardback(
            cardBackId = response.cardBackId,
            name = response.name,
            description = response.description,
            source = response.source,
            enabled = response.enabled,
            img = response.img,
            imgAnimated = response.imgAnimated,
            sortCategory = response.sortCategory,
            sortOrder = response.sortOrder,
            locale = response.locale
        )
    }
}