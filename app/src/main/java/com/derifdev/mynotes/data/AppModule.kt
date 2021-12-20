package com.derifdev.mynotes.data

import android.app.Application
import androidx.room.Room
import com.derifdev.mynotes.data.data_access.NoteDatabase
import com.derifdev.mynotes.data.repository.NoteRepository
import com.derifdev.mynotes.data.repository.NoteRepositoryImpl
import com.derifdev.mynotes.data.use_case.AddNote
import com.derifdev.mynotes.data.use_case.GetNoteById
import com.derifdev.mynotes.data.use_case.GetNotes
import com.derifdev.mynotes.data.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton

    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            "db_note",
        ).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase) : NoteRepository {
        return NoteRepositoryImpl(db.noteDao())
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository) : NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            addNote = AddNote(repository),
            getNoteById = GetNoteById(repository)
        )
    }
}