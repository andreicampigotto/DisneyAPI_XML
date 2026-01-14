package com.example.disneyxml.data.remote.response

import com.google.gson.annotations.SerializedName

data class DisneyCharacterResponse(
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
