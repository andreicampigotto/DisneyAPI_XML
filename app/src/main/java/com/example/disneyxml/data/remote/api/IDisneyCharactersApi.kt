package com.example.disneyxml.data.remote.api

import com.example.disneyxml.data.remote.response.DisneyCharacterResponse
import retrofit2.http.GET

interface IDisneyCharactersApi {

    @GET("data")
    suspend fun getCharacters(): List<DisneyCharacterResponse>
}