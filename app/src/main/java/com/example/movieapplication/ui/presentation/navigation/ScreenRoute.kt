package com.example.movieapplication.ui.presentation.navigation

sealed class ScreenRoute(val route:String) {
    object ScreenA: ScreenRoute("screen_a")
    object ScreenB: ScreenRoute("screen_b")
}