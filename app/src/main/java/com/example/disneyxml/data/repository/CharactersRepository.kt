package com.example.disneyxml.data.repository

import com.example.disneyxml.data.model.CharacterData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

sealed class State<out T> {
    object Loading : State<Nothing>()
    data class Success<out T>(val model: T) : State<T>()
    data class Error(val message: String?) : State<Nothing>()
}

class CharactersRepository(
    private val ICharacterApi: ICharacterApi,
) : ICharacterRepository {
    override suspend fun getCharacters(): State<CharacterData>{

        return withContext(Dispatchers.IO) {
            try {
                val response = ICharacterApiApi.Info()
                State.Success(CharacterResponse)

            } catch (ex: IOException) {
                // Network Error
                State.Error(message = ex.localizedMessage)
            } catch (ex: Exception) {
               State.Error(message = ex.localizedMessage)
            }
        }
    }

}
