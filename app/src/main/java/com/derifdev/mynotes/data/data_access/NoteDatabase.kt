package com.derifdev.mynotes.data.data_access

import androidx.room.Database
import androidx.room.RoomDatabase
import com.derifdev.mynotes.data.models.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}