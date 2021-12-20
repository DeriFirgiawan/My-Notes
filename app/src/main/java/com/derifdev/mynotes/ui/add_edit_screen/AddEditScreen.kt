package com.derifdev.mynotes.ui.add_edit_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.derifdev.mynotes.R
import com.derifdev.mynotes.data.navigation.Screen
import com.derifdev.mynotes.ui.components.HeaderBack
import com.derifdev.mynotes.ui.components.NoteSection
import com.derifdev.mynotes.ui.theme.Black500

@Composable
fun AddEditScreen(
    navController: NavController,
    viewModel: AddEditViewModel = hiltViewModel()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(AddEditNoteEvent.SaveNote)
                },
                backgroundColor = Black500,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = "Save Note",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    ) {
        Column {
            HeaderBack(navController)
            NoteSection(
                title = viewModel.noteTitle.value.title,
                "Title",
                content = viewModel.noteContent.value.content,
                "Enter something here ...",
                onChangeTitle = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                },
                onChangeContent = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
                }
            )
        }
    }
}