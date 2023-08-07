package com.hearthstone.feature_home

import com.hearthstone.feature_home.data.HomeRepository
import com.hearthstone.feature_home.data.HomeService
import com.hearthstone.feature_home.di.HomeModule
import com.hearthstone.feature_home.domain.HomeUseCase
import com.hearthstone.feature_home.domain.mapper.CardMapper
import com.hearthstone.feature_home.presentation.DetailViewModel
import com.hearthstone.feature_home.presentation.HomeViewModel
import io.mockk.mockk
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.check.checkModules

class HomeModuleTest : AutoCloseKoinTest() {

    private val mockModule = module {
        single<HomeService> { mockk(relaxed = true) }
        single<HomeRepository> { mockk(relaxed = true) }
        single<HomeUseCase> { mockk(relaxed = true) }
        single<CardMapper> { mockk(relaxed = true) }
        single<DetailViewModel> { mockk(relaxed = true) }
        single<HomeViewModel> { mockk(relaxed = true) }
    }

    @Test
    fun check_all_modules() {
        koinApplication {
            modules(HomeModule.instance + mockModule)
        }.checkModules()
    }
}