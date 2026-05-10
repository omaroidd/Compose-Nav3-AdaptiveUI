package com.omaroid.adaptiveui.data

data class Note(
    val id: Int,
    val title: String,
    val content: String
)

val notes = listOf(
    Note(1, "Compose", "Compose is declarative UI"),
    Note(2, "Nav3", "Metadata-based navigation"),
    Note(3, "Android", "Modern development")
)