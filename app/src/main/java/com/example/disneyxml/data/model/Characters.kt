package com.example.disneyxml.data.model

import com.google.gson.annotations.SerializedName

data class CharacterInfo(
    @SerializedName("count") val count: Long,
    @SerializedName("totalPages") val totalPages: Long,
    //@SerializedName("id")
//    previousPage": null,
//    @SerializedName("id")
//    "nextPage": "http://api.disneyapi.dev/character?page=2&pageSize=50"
)

data class CharacterResponse(
    val data: List<CharacterData>
)
data class CharacterData(
    @SerializedName("id") val id: Long,
    @SerializedName("films")  val films: List<String>,
    @SerializedName("shortFilms") val shortFilms: List<String>,
    @SerializedName("tvShows") val tvShows: List<String>,
    @SerializedName("videoGames") val videoGames: List<String>,
    @SerializedName("parkAttractions") val parkAttractions: List<String>,
    @SerializedName("allies") val allies: List<String>,
    @SerializedName("enemies") val enemies: List<String>,
    @SerializedName("name") val name: String,
    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("url") val url: String?
)