package com.derifdev.mynotes.data.use_case

import com.derifdev.mynotes.data.models.Note
import com.derifdev.mynotes.data.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.addNote(note)
    }
}