package org.montra.crudmuliplatform

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.montra.crudmuliplatform.di.dataModule
import org.montra.crudmuliplatform.di.initKoin
import org.montra.crudmuliplatform.di.viewModelsModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin{
            androidContext(this@MainApplication)
            modules(dataModule + viewModelsModule)
        }
    }
}