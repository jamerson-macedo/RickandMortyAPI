package com.example.rickandmortyapi.domain.use_case

import com.example.rickandmortyapi.data.Result
import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.model.Characters
import com.example.rickandmortyapi.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: CharacterRepository) {
    operator fun invoke(page: Int): Flow<Result<List<Characters>>> {
        return repository.getCharacters(page)
    }

}