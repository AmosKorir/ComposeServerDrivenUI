package com.safaricom.composeserverdrivenui.di

import com.safaricom.composeserverdrivenui.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


class ViewModelModule {

    companion object {
        val module = org.koin.dsl.module {
            viewModel {
                MainViewModel(get())
            }
        }
    }
}
