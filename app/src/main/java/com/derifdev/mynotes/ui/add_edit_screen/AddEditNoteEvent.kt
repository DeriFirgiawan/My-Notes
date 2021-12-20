package com.derifdev.mynotes.ui.add_edit_screen

sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String): AddEditNoteEvent()
    data class EnteredContent(val value: String): AddEditNoteEvent()
    object SaveNote: AddEditNoteEvent()
}
