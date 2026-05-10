package com.omaroid.adaptiveui.presentation.adaptive

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun rememberWindowSize(): WindowSize {
    val width = LocalConfiguration.current.screenWidthDp

    return when {
        width < 600 -> WindowSize.COMPACT
        width < 840 -> WindowSize.MEDIUM
        else -> WindowSize.EXPANDED
    }
}