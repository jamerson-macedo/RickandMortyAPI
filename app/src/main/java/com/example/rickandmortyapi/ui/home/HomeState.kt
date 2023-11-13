package com.example.rickandmortyapi.ui.home

import com.example.rickandmortyapi.domain.model.Characters

data class HomeState(
    val characteres: List<Characters> = emptyList(),
    val showPreview: Boolean = false,
    val showNext: Boolean = false,
    val isLoading:Boolean=false
)
