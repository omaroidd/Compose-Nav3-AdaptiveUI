package com.omaroid.adaptiveui.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.omaroid.adaptiveui.presentation.model.Note

@Composable
fun NoteDetailScreen(
    note: Note?,
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    onOpenExtra: () -> Unit = {}
) {

    if (note == null) return

    Column(modifier.padding(16.dp)) {
        Text(note.title)
        Text(note.content)

        Spacer(Modifier.height(12.dp))

        Button(onClick = onOpenExtra) {
            Text("Extra Pane")
        }
    }
}