package com.omaroid.adaptiveui.presentation.navigation

sealed class NavKey {
    data object List : NavKey()
    data class Detail(val id: Int) : NavKey()
    data class Extra(val id: Int) : NavKey()
}