package com.example.disneyxml.data.repository

import com.example.disneyxml.data.model.CharacterData

interface ICharacterRepository {
    suspend fun getCharacters(): List<CharacterData>?
}