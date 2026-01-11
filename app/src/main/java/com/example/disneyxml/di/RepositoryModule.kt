package com.example.disneyxml.di

import com.example.disneyxml.data.repository.DisneyCharactersRepository
import com.example.disneyxml.data.repository.IDisneyCharacterRepository
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        factory<IDisneyCharacterRepository> { DisneyCharactersRepository(get()) }
    }
}