package com.derifdev.mynotes.data.use_case

import com.derifdev.mynotes.data.models.Note
import com.derifdev.mynotes.data.repository.NoteRepository

class GetNoteById(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}