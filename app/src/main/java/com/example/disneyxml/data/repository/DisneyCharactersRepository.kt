package com.example.disneyxml.data.repository

import com.example.disneyxml.data.model.DisneyCharacterModel
import com.example.disneyxml.data.remote.api.IDisneyCharactersApi
import com.example.disneyxml.repository.IDisneyCharacterRepository
import com.example.disneyxml.domain.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class DisneyCharactersRepository (
    private  val disneyCharactersApi: IDisneyCharactersApi,
) : IDisneyCharacterRepository {

private  fun <T> processData(response: Response<T>): T? {
    return if (response.isSuccessful) response.body() else null
}

    override suspend fun getCharacters(): List<DisneyCharacterModel> {
        val resultAPI = withContext(Dispatchers.Default) {
            val response = disneyCharactersApi.getCharacters()
            val processedResponse = processData(response.asDomainModel)
            processedResponse
        }
        return resultAPI
    }



}


