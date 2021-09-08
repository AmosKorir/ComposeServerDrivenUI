package com.safaricom.composeserverdrivenui.di

import com.safaricom.composeserverdrivenui.data.repository.SampleDataRepository
import com.safaricom.composeserverdrivenui.domain.SampleDataRepositoryInter

class RepositoryModule {
    companion object {
        val module = org.koin.dsl.module {
            single { SampleDataRepository (get()) as SampleDataRepositoryInter }
        }
    }
}