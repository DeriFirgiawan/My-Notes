package com.derifdev.mynotes.data.repository

import com.derifdev.mynotes.data.data_access.NoteDao
import com.derifdev.mynotes.data.models.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getAllNote()
    }

    override suspend fun addNote(note: Note) {
        dao.addNote(note)
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }
}