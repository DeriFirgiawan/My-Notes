package com.derifdev.mynotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.derifdev.mynotes.R
import com.derifdev.mynotes.ui.theme.Black400

@Composable
fun Header() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Notes", style = MaterialTheme.typography.h1, fontWeight = FontWeight.Bold)
        
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(Black400)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = "Search",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(Black400)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_info_24),
                    contentDescription = "Info",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header()
}
