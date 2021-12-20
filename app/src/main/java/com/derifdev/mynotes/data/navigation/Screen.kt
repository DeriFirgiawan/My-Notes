package com.derifdev.mynotes.data.navigation

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash_screen")
    object HomeScreen: Screen("home_screen")
    object AddEditScreen: Screen("add_edit_screen")
}
