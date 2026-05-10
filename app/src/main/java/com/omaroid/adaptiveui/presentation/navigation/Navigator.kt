package com.omaroid.adaptiveui.presentation.navigation

import androidx.compose.runtime.mutableStateOf


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Navigator {

    private val _state = MutableStateFlow<NavState>(NavState.List)

    val state: StateFlow<NavState> = _state.asStateFlow()

    fun navigate(newState: NavState) {
        _state.value = newState
    }

    fun back() {
        when (val current = _state.value) {

            is NavState.Detail -> {
                _state.value = NavState.List
            }

            is NavState.Extra -> {
                _state.value = NavState.Detail(current.noteId)
            }

            else -> Unit
        }
    }
}