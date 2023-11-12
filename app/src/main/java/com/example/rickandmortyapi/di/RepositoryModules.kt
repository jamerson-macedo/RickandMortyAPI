package com.example.rickandmortyapi.di

import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.data.repository.CharacterRepositoryImplementation
import com.example.rickandmortyapi.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModules {
    @Binds
    abstract fun bindCharacterRepository(impl:CharacterRepositoryImplementation):CharacterRepository
}