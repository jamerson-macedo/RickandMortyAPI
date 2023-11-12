package com.example.rickandmortyapi.domain.repository

import com.example.rickandmortyapi.data.Result
import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.model.Characters
import kotlinx.coroutines.flow.Flow


interface CharacterRepository {
    fun getCharacters(page:Int): Flow<Result<List<Characters>>>
    suspend fun getCharacter(id:Int):Result<Character>
}