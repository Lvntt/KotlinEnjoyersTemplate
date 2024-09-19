package com.example.kotlinenjoyerstemplate

import android.app.Application
import com.example.kotlinenjoyerstemplate.contract_details.di.contractDetailsPresentationModule
import com.example.kotlinenjoyerstemplate.core.di.coreDataModule
import com.example.kotlinenjoyerstemplate.map.di.provideMapPresentationModule
import com.example.kotlinenjoyerstemplate.object_details.di.objectDetailsPresentationModule
import com.example.kotlinenjoyerstemplate.plan_details.di.planDetailsPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HackathonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HackathonApplication)
            modules(
                coreDataModule(),

                provideMapPresentationModule(),
                objectDetailsPresentationModule(),
                planDetailsPresentationModule(),
                contractDetailsPresentationModule(),
            )
        }
    }
}