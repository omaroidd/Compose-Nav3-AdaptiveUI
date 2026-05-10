package com.omaroid.adaptiveui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.omaroid.adaptiveui.presentation.adaptive.AdaptiveApp
import com.omaroid.adaptiveui.presentation.navigation.Navigator


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navigator = remember { Navigator() }

            AdaptiveApp(navigator = navigator)
        }
    }
}