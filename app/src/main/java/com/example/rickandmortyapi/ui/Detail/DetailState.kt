package com.example.rickandmortyapi.ui.Detail

import com.example.rickandmortyapi.domain.model.Character

data class DetailState(
    val character: Character? = null,
    val isLoading: Boolean = false
)