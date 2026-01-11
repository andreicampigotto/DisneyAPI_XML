package com.example.disneyxml.data.repository

import com.example.disneyxml.data.model.DisneyCharacterData
import com.example.disneyxml.data.remote.api.IDisneyCharactersApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DisneyCharactersRepository (
    private  val disneyCharactersApi: IDisneyCharactersApi,
) : IDisneyCharacterRepository {

private  fun <T> processData(response: Response<T>): T? {
    return if (response.isSuccessful) response.body() else null
}

    override suspend fun getAllCharacters(): List<DisneyCharacterData>? {
        val resultAPI = withContext(Dispatchers.Default) {
            val response = disneyCharactersApi.getCharacters()
            val processedResponse = processData(response)
            processedResponse?.data
        }
        return resultAPI
    }

}


