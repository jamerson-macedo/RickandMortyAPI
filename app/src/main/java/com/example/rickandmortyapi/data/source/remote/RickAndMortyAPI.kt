package com.example.rickandmortyapi.data.source.remote

import com.example.rickandmortyapi.data.source.remote.dto.Characterdto
import com.example.rickandmortyapi.data.source.remote.dto.Charactersdto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyAPI {
    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page:Int
    ): Charactersdto
@GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id:Int
    ): Characterdto
}