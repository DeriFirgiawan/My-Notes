package com.derifdev.mynotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.derifdev.mynotes.data.models.Note
import com.derifdev.mynotes.ui.theme.Pink200

@Composable
fun CardContent(
    note: Note,
    modifier: Modifier = Modifier,
    text: String,
) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Card(modifier = modifier) {
            Box(
                modifier = Modifier.background(Pink200).padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = text, style = MaterialTheme.typography.h2)
            }
        }
    }
}