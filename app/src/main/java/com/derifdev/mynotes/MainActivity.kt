package com.derifdev.mynotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.derifdev.mynotes.data.navigation.Navigation
import com.derifdev.mynotes.ui.theme.MyNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }
}