package com.derifdev.mynotes.data.use_case

import com.derifdev.mynotes.data.models.Note
import com.derifdev.mynotes.data.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repository: NoteRepository
) {
    operator fun invoke() : Flow<List<Note>> {
        return repository.getNotes()
    }
}