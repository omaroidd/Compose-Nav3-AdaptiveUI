package com.omaroid.adaptiveui.presentation.adaptive

import androidx.compose.runtime.Composable
import com.omaroid.adaptiveui.data.notes
import com.omaroid.adaptiveui.presentation.navigation.NavState

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
                        onNavigate(NavState.Extra(state.noteId))
                    }
                )

                is NavState.Extra -> NoteExtraScreen(note)
            }
        }

        WindowSize.MEDIUM -> {
            Row {
                NotesListScreen(
                    modifier = Modifier.weight(1f),
                    onClick = { onNavigate(NavState.Detail(it.id)) }
                )

                NoteDetailScreen(
                    modifier = Modifier.weight(1f),
                    note = note,
                    onBack = {},
                    onOpenExtra = {
                        onNavigate(NavState.Extra(state.noteId))
                    }
                )
            }
        }

        WindowSize.EXPANDED -> {
            Row {

                NotesListScreen(
                    modifier = Modifier.weight(1f),
                    onClick = { onNavigate(NavState.Detail(it.id)) }
                )

                NoteDetailScreen(
                    modifier = Modifier.weight(1f),
                    note = note,
                    onBack = {},
                    onOpenExtra = {}
                )

                NoteExtraScreen(
                    modifier = Modifier.weight(1f),
                    note = note
                )
            }
        }
    }
}