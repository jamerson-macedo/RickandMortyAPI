package com.example.rickandmortyapi.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.data.Result
import com.example.rickandmortyapi.domain.use_case.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val getCharactersUseCase: GetCharactersUseCase) :
    ViewModel() {
    var state by mutableStateOf(HomeState(isLoading = true))
        private set
    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    private var currentPage = 1

    init {
        getCharacters(false)
    }

    fun getCharacters(increasse: Boolean) {
        viewModelScope.launch {
            if (increasse) currentPage++ else if (currentPage > 1) currentPage--
            val showPreviews = currentPage > 1
            val showNext = currentPage < 42
            getCharactersUseCase(currentPage).onEach { result ->
                when (result) {
                    is Result.Success -> {
                        state = state.copy(
                            characteres = result.data ?: emptyList(),
                            isLoading = false,
                            showPreview = showPreviews,
                            showNext = showNext

                        )
                    }

                    is Result.Error -> {
                        state = state.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(UIEvent.showSnackbar(result.message ?: "Desconhecido"))

                    }
                    is Result.Loading->{
                        state = state.copy(
                            isLoading = true
                        )


                    }

                }
                //lanca a corrotina nno scopo do viewmodel

            }.launchIn(this)

        }


    }

    sealed class UIEvent {
        data class showSnackbar(val message: String) : UIEvent()
    }
}

