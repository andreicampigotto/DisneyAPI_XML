package com.example.disneyxml.di

import com.example.disneyxml.data.network.HTTPClient
import com.example.disneyxml.data.remote.api.IDisneyCharactersApi
import org.koin.dsl.module

object NetworkModule {
    val module = module {
        single { HTTPClient() }
        factory { get<HTTPClient>().create(IDisneyCharactersApi::class) }
    }
}