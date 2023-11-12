package com.example.rickandmortyapi.data.source.remote.dto

import com.example.rickandmortyapi.domain.model.Characters

data class Charactersdto(
    val info: Info,
    val results: List<Result>
)

fun Charactersdto.TolistCharacters(): List<Characters> {
    var result = results.mapIndexed { _, result ->
        Characters(
            id = result.id, name = result.name, specie = result.species, image = result.image
        )
    }
    return result
}