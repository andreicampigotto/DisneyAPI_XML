package com.example.disneyxml.data.repository

import com.example.disneyxml.data.model.CharacterData
import com.example.disneyxml.data.model.CharacterResponse

interface ICharacterRepository {
    suspend fun getCharacters(): List<CharacterData>?
}