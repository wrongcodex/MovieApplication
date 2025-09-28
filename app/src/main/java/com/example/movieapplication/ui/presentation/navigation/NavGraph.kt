package com.example.movieapplication.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapplication.core.viewmodel.MovieViewModel
import com.example.movieapplication.ui.presentation.screens.ScreenA

@Composable
fun NavGraph(navController: NavHostController, viewModel: MovieViewModel) {
    //val navController: NavHostController = rememberNavController()
    NavHost(navController, startDestination = ScreenRoute.ScreenA.route) {
        composable(ScreenRoute.ScreenA.route) {
            ScreenA(navController, viewModel)
        }
    }
}