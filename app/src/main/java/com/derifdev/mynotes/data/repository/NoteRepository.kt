package com.derifdev.mynotes.data.repository

import com.derifdev.mynotes.data.models.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes() : Flow<List<Note>>
    suspend fun addNote(note: Note)
    suspend fun getNoteById(id: Int) : Note?
}