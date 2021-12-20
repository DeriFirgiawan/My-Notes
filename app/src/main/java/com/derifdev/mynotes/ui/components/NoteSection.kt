package com.derifdev.mynotes.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.derifdev.mynotes.ui.theme.Black500

@Composable
fun NoteSection(
    title: String,
    hintTitle: String,
    content: String,
    hintContent: String,
    onChangeTitle: (String) -> Unit,
    onChangeContent: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = onChangeTitle,
            textStyle = MaterialTheme.typography.h1,
            maxLines = 4,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Black500,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = hintTitle,
                    maxLines = 4,
                    style = MaterialTheme.typography.h1
                )
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = content,
            onValueChange = onChangeContent,
            textStyle = MaterialTheme.typography.body1,
            maxLines = 4,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Black500,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = hintContent,
                    maxLines = 4,
                    style = MaterialTheme.typography.body1
                )
            }
        )
    }
}