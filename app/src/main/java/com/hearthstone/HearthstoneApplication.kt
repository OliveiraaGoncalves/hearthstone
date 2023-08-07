package com.hearthstone

import android.app.Application
import com.hearthstone.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HearthstoneApplication : Application() {

    override fun onCreate() {
        super.onCreate()
       startKoin{
            androidContext(this@HearthstoneApplication)
            modules(AppModule.list)
       }
    }
}