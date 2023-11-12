package com.example.rickandmortyapi.data.repository

import com.example.rickandmortyapi.data.Result
import com.example.rickandmortyapi.data.source.remote.RickAndMortyAPI
import com.example.rickandmortyapi.data.source.remote.dto.ToCharacter
import com.example.rickandmortyapi.data.source.remote.dto.TolistCharacters
import com.example.rickandmortyapi.domain.model.Character
import com.example.rickandmortyapi.domain.model.Characters
import com.example.rickandmortyapi.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterRepositoryImplementation @Inject constructor(
    private val api: RickAndMortyAPI
) : CharacterRepository {
    override fun getCharacters(page: Int): Flow<Result<List<Characters>>> = flow {
        emit(Result.Loading())
        try {
            val response = api.getCharacters(page).TolistCharacters()
            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(Result.Error(e.message.toString(), null))
        }catch (io:IOException){
            emit(Result.Error(io.message.toString(), null))

        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        val response=try {
            api.getCharacter(id)
        }catch (e:Exception){
            return Result.Error(e.message.toString(),null)
        }
        return Result.Success(response.ToCharacter())
    }
}