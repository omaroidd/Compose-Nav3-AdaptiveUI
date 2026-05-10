package com.omaroid.adaptiveui.presentation.adaptive

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.omaroid.adaptiveui.presentation.navigation.Navigator

@Composable
fun AdaptiveApp(navigator: Navigator) {

    val state by navigator.state.collectAsState()

    val windowSize = rememberWindowSize()

    AdaptiveScaffold(
        windowSize = windowSize,
        state = state,
        onNavigate = { navigator.navigate(it) },
        onBack = { navigator.back() }
    )
}