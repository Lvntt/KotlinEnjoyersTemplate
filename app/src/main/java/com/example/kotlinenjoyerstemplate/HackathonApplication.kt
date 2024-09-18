package com.example.kotlinenjoyerstemplate

import android.app.Application
import com.example.kotlinenjoyerstemplate.map.di.provideMapPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HackathonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HackathonApplication)
            modules(
                provideMapPresentationModule()
            )
        }
    }
}