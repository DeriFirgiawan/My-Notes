package com.derifdev.mynotes.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.derifdev.mynotes.R
import com.derifdev.mynotes.data.navigation.Screen
import com.derifdev.mynotes.ui.components.CardContent
import com.derifdev.mynotes.ui.components.Header
import com.derifdev.mynotes.ui.theme.Black500

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddEditScreen.route + "/${0}")
                },
                backgroundColor = Black500,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = "Add Note",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    ) {
        Column {
            Header()
            if (state.value.notes.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.cuate), contentDescription = "Image Not Found")
                    Text(text = "Sorry you haven't anything dude", style = MaterialTheme.typography.h2)
                }
            } else {
                LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
                    items(state.value.notes) {
                        CardContent(
                            note = it,
                            text = it.title,
                            modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth().clickable {
                                    navController.navigate(Screen.AddEditScreen.route + "/${it.id}")
                                }
                        )
                    }
                }
            }
        }
    }
}