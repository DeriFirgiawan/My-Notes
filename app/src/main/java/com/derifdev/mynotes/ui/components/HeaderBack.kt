package com.derifdev.mynotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.derifdev.mynotes.R
import com.derifdev.mynotes.data.navigation.Screen
import com.derifdev.mynotes.ui.theme.Black400

@Composable
fun HeaderBack(
    navController: NavController,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        IconButton(
            onClick = { navController.navigate(Screen.HomeScreen.route) },
            modifier = Modifier.clip(RoundedCornerShape(15.dp))
                .background(Black400),

            ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                contentDescription = "Back",
                tint = Color.White,
            )
        }
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(Black400)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_edit_24),
                contentDescription = "Edit",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun HeaderBackPreview() {
    HeaderBackPreview()
}