package com.safaricom.composeserverdrivenui

import android.app.Application
import com.safaricom.composeserverdrivenui.di.ApiModule
import com.safaricom.composeserverdrivenui.di.RepositoryModule
import com.safaricom.composeserverdrivenui.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ComposeServerDrivenUI : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    ApiModule.module,
                    RepositoryModule.module,
                    ViewModelModule.module
                )
            )
        }
    }
}