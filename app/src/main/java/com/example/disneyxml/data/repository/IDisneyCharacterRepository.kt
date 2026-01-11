package com.example.disneyxml.data.repository

import com.example.disneyxml.data.model.DisneyCharacterData

interface IDisneyCharacterRepository {
    suspend fun getAllCharacters(): List<DisneyCharacterData>?
}