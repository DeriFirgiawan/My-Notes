package com.derifdev.mynotes.ui.homescreen

import com.derifdev.mynotes.data.models.Note

data class HomeScreenState(
    val notes: List<Note> = emptyList()
)
