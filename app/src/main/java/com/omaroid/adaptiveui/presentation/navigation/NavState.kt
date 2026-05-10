package com.omaroid.adaptiveui.presentation.navigation

sealed class NavState {

    data object List : NavState()

    data class Detail(val noteId: Int) : NavState()

    data class Extra(val noteId: Int) : NavState()
}