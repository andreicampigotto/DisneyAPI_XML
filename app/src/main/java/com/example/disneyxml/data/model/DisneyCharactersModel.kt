package com.example.disneyxml.data.model

import com.google.gson.annotations.SerializedName

data class DisneyCharacterInfo(
    @SerializedName("count") val count: Long,
    @SerializedName("totalPages") val totalPages: Long,
    //@SerializedName("id")
//    previousPage": null,
//    @SerializedName("id")
//    "nextPage": "http://api.disneyapi.dev/character?page=2&pageSize=50"
)

data class DisneyCharacterModel(
    val id: Long,
    val films: List<String>,
    val shortFilms: List<String>,
    val tvShows: List<String>,
    val videoGames: List<String>,
    val parkAttractions: List<String>,
    val allies: List<String>,
    val enemies: List<String>,
    val name: String,
    val imageUrl: String?,
    val url: String?
)