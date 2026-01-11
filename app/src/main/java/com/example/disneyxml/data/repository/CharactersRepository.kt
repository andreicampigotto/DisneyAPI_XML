package com.example.disneyxml.data.repository

import com.example.disneyxml.data.model.CharacterData
import com.example.disneyxml.data.remote.api.IDisneyCharactersApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DisneyCharactersRepository (
    private val iDisneyCharactersApi: IDisneyCharactersApi,
){

private fun <T> processData(response: Response<T>): T? {
    return if (response.isSuccessful) response.body() else null
}

    suspend fun getCharacters(): List<CharacterData>? {
        val resultAPI = withContext(Dispatchers.Main) {
                val response = iDisneyCharactersApi.getCharacters()
                val processedResponse = processData(response)
                processedResponse?.data
    }
        return resultAPI
    }
}


