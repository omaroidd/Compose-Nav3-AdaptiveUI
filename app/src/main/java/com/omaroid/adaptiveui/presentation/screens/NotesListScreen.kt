package com.omaroid.adaptiveui.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.omaroid.adaptiveui.data.notes
import com.omaroid.adaptiveui.presentation.model.Note

@Composable
fun NotesListScreen(
    modifier: Modifier = Modifier,
    onClick: (Note) -> Unit = {}
) {
    LazyColumn(modifier) {
        items(notes) { note ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onClick(note) }
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(note.title)
                }
            }
        }
    }
}