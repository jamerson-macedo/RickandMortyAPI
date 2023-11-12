package com.example.rickandmortyapi.data.source.remote.dto

import com.example.rickandmortyapi.domain.model.Character

data class Characterdto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun Characterdto.ToCharacter(): Character {
    return Character(
        id, name, status, species, gender, origin, location, image
    )
}