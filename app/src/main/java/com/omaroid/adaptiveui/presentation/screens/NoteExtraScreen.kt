package com.omaroid.adaptiveui.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.omaroid.adaptiveui.presentation.model.Note

@Composable
fun NoteExtraScreen(
    note: Note?,
    modifier: Modifier = Modifier
) {
    if (note == null) return

    Column(modifier.padding(16.dp)) {
        Text("Extra Info")
        Text("Note ID: ${note.id}")
    }
}