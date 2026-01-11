package com.example.disneyxml.repository

import com.example.disneyxml.data.model.DisneyCharacterData

interface IDisneyCharacterRepository {

    suspend fun getCharacters(): List<DisneyCharacterData>
}