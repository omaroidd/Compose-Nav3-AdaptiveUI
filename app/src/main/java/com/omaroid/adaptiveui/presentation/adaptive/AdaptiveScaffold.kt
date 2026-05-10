package com.omaroid.adaptiveui.presentation.adaptive

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.omaroid.adaptiveui.data.notes
import com.omaroid.adaptiveui.presentation.navigation.NavState
import com.omaroid.adaptiveui.presentation.screens.NoteDetailScreen
import com.omaroid.adaptiveui.presentation.screens.NoteExtraScreen
import com.omaroid.adaptiveui.presentation.screens.NotesListScreen

@Composable
fun AdaptiveScaffold(
    windowSize: WindowSize,
    state: NavState,
    onNavigate: (NavState) -> Unit,
    onBack: () -> Unit
) {

    val note = when (state) {
        is NavState.Detail -> notes.find { it.id == state.noteId }
        is NavState.Extra -> notes.find { it.id == state.noteId }
        else -> null
    }

    val detailId = when (state) {
        is NavState.Detail -> state.noteId
        is NavState.Extra -> state.noteId
        else -> null
    }

    when (windowSize) {

        WindowSize.COMPACT -> {
            when (state) {
                is NavState.List -> NotesListScreen(
                    onClick = { onNavigate(NavState.Detail(it.id)) }
                )

                is NavState.Detail -> NoteDetailScreen(
                    note = note,
                    onBack = onBack,
                    onOpenExtra = {
                        state.noteId.let {
                            onNavigate(NavState.Extra(it))
                        }
                    }
                )

                is NavState.Extra -> NoteExtraScreen(
                    note = note,
                    onBack = onBack
                )
            }
        }

        WindowSize.MEDIUM -> {
            Row {
                NotesListScreen(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    onClick = { onNavigate(NavState.Detail(it.id)) }
                )

                NoteDetailScreen(
                    modifier = Modifier.weight(1.5f).fillMaxHeight(),
                    note = note,
                    onBack = null, // No back button needed in split view
                    onOpenExtra = {
                        detailId?.let {
                            onNavigate(NavState.Extra(it))
                        }
                    }
                )
            }
        }

        WindowSize.EXPANDED -> {
            Row {
                NotesListScreen(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    onClick = { onNavigate(NavState.Detail(it.id)) }
                )

                NoteDetailScreen(
                    modifier = Modifier.weight(1.5f).fillMaxHeight(),
                    note = note,
                    onBack = null,
                    onOpenExtra = {}
                )

                NoteExtraScreen(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    note = note,
                    onBack = null
                )
            }
        }
    }
}
