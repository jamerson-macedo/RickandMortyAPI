package com.example.rickandmortyapi.domain.use_case

import com.example.rickandmortyapi.data.Result
import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int): Result<Character>{
        return repository.getCharacter(id)
    }
}