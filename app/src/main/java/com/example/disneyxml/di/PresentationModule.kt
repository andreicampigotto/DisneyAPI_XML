package com.example.disneyxml.di

import com.example.disneyxml.viewModel.DisneyCharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationModule {
    val module = module {
        viewModel { DisneyCharacterViewModel(get()) }
    }
}