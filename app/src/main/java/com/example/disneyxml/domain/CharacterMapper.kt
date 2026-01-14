package com.example.disneyxml.domain

import com.example.disneyxml.data.model.DisneyCharacterModel
import com.example.disneyxml.data.remote.response.DisneyCharacterResponse

fun DisneyCharacterResponse.asDomainModel() =
    DisneyCharacterModel(
        id = id,
        films = films,
        shortFilms = shortFilms,
        tvShows = tvShows,
        videoGames = videoGames,
        parkAttractions = parkAttractions,
        allies = allies,
        enemies= enemies,
        name = name,
        imageUrl = imageUrl,
        url= url,
    )