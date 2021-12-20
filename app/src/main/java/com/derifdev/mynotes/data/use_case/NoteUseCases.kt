package com.derifdev.mynotes.data.use_case

data class NoteUseCases(
    val getNotes: GetNotes,
    val addNote: AddNote,
    val getNoteById: GetNoteById
)
