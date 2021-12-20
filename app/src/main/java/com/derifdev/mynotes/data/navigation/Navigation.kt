package com.derifdev.mynotes.data.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.derifdev.mynotes.ui.add_edit_screen.AddEditScreen
import com.derifdev.mynotes.ui.homescreen.HomeScreen
import com.derifdev.mynotes.ui.splashscreen.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.AddEditScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { entry ->
            AddEditScreen(navController = navController)
        }
    }
}