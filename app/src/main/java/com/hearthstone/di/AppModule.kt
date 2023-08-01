package com.hearthstone.di

import android.content.res.Resources
import com.hearthstone.core_networking.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object AppModule {
    private val module = module {
        single<Resources> { androidContext().resources }
    }
    val list  = module + NetworkModule.module
}