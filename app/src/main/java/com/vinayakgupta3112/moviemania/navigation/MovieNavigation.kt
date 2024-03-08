package com.vinayakgupta3112.moviemania.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vinayakgupta3112.moviemania.screens.details.DetailsScreen
import com.vinayakgupta3112.moviemania.screens.home.HomeScreen


/*
* Navigation in jetpack compose ->
* ------------------------------------
* | Navigation                       |
* |   Navigation Controller          |
* |       Navigation Host            |
* |           Navigation Graph       |
* ------------------------------------
* */
@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            // here we pass where this should lead too
            HomeScreen(navController = navController)
        }
        composable(
            MovieScreens.DetailsScreen.name+ "/{movie}",
            arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})
        ) {backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}