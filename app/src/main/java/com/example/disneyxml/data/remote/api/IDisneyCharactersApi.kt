package com.example.disneyxml.data.remote.api

import com.example.disneyxml.data.model.DisneyCharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface IDisneyCharactersApi {

    @GET("data")
    suspend fun getCharacters():Response <DisneyCharacterResponse>
}