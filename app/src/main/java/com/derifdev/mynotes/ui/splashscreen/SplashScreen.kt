package com.derifdev.mynotes.ui.splashscreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.derifdev.mynotes.data.navigation.Screen
import com.derifdev.mynotes.ui.theme.Black500
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 900,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        delay(2000L)
        navController.navigate(Screen.HomeScreen.route)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black500),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "_derifdev",
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.Bold
        )
    }
}