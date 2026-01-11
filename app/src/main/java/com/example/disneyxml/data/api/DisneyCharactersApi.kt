package com.example.disneyxml.data.api

import com.example.disneyxml.data.model.CharacterData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DisneyCharactersApi {

    @GET("data")
    suspend fun getCharacters(): CharacterData


//    fun provideRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://api.disneyapi.dev/character")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
}