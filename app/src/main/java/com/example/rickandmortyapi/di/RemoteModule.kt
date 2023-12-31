package com.example.rickandmortyapi.di

import com.example.rickandmortyapi.data.source.remote.RickAndMortyAPI
import com.example.rickandmortyapi.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    // instancia do retrofit
    @Provides
    @Singleton
    fun provideRickMortyApi(): RickAndMortyAPI {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RickAndMortyAPI::class.java)
    }
}