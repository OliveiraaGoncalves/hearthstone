package com.hearthstone.feature_home.di

import com.hearthstone.feature_home.data.HomeRepository
import com.hearthstone.feature_home.data.HomeRepositoryImpl
import com.hearthstone.feature_home.data.HomeService
import com.hearthstone.feature_home.domain.HomeUseCase
import com.hearthstone.feature_home.domain.HomeUseCaseImpl
import com.hearthstone.feature_home.domain.mapper.CardMapper
import com.hearthstone.feature_home.domain.mapper.CardMapperImpl
import com.hearthstone.feature_home.presentation.DetailViewModel
import com.hearthstone.feature_home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object HomeModule {
    val instance = module {
        viewModel {
            HomeViewModel(
                useCase = get(),
            )
        }

        viewModel {
            DetailViewModel(
                useCase = get()
            )
        }

        factory<HomeUseCase> {
            HomeUseCaseImpl(
                repository = get(),
                mapper = get()
            )
        }

        factory<CardMapper> {
            CardMapperImpl()
        }

        factory<HomeRepository> {
            HomeRepositoryImpl(
                homeService = get(),
            )
        }

        factory { get<Retrofit>().create(HomeService::class.java) }
    }
}