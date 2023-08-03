package com.hearthstone.feature_home.di

import com.hearthstone.feature_home.data.CardBackRepository
import com.hearthstone.feature_home.data.CardBackRepositoryImpl
import com.hearthstone.feature_home.data.CardbackService
import com.hearthstone.feature_home.domain.CardBackUseCase
import com.hearthstone.feature_home.domain.CardBackUseCaseImpl
import com.hearthstone.feature_home.domain.mapper.CardBackMapper
import com.hearthstone.feature_home.domain.mapper.CardBackMapperImpl
import com.hearthstone.feature_home.presentation.CardBackViewModel
import dev.krud.shapeshift.ShapeShift
import dev.krud.shapeshift.ShapeShiftBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.modelmapper.ModelMapper
import retrofit2.Retrofit

object HomeModule {
    val module = module {
        viewModel {
            CardBackViewModel(
                useCase = get(),
            )
        }

        factory<CardBackUseCase> {
            CardBackUseCaseImpl(
                repository = get(),
                mapper = get()
            )
        }

        factory<CardBackMapper> {
            CardBackMapperImpl()
        }

        factory<CardBackRepository> {
            CardBackRepositoryImpl(
                cardbackService = get(),
            )
        }

        factory { get<Retrofit>().create(CardbackService::class.java) }
    }
}