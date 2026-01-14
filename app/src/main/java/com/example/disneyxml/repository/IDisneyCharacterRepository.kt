package com.example.disneyxml.repository

import com.example.disneyxml.data.model.DisneyCharacterModel

interface IDisneyCharacterRepository {

    suspend fun getCharacters(): List<DisneyCharacterModel>
}