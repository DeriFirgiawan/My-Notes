package com.derifdev.mynotes.ui.add_edit_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.derifdev.mynotes.data.models.Note
import com.derifdev.mynotes.data.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _noteTitle = mutableStateOf(NoteTextFieldState(
        hintTitle = "Title"
    ))
    val noteTitle: State<NoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(NoteTextFieldState(
        hintContent = "Enter something here ..."
    ))
    val noteContent: State<NoteTextFieldState> = _noteContent

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<Int>("id")?.let { id ->
            if (id != -1) {
                viewModelScope.launch {
                    noteUseCases.getNoteById(id)?.also {
                        _noteTitle.value = noteTitle.value.copy(
                            title = it.title,
                        )
                        _noteContent.value = noteContent.value.copy(content = it.content)
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditNoteEvent) {
        when (event) {
            is AddEditNoteEvent.EnteredTitle -> {
                _noteTitle.value = noteTitle.value.copy(title = event.value)
            }
            is AddEditNoteEvent.EnteredContent -> {
                _noteContent.value = noteContent.value.copy(content = event.value)
            }
            is AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(
                        Note(
                            title = noteTitle.value.title,
                            content = noteContent.value.content
                        )
                    )
                    _eventFlow.emit(UiEvent.SaveNote)
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveNote: UiEvent()
    }
}