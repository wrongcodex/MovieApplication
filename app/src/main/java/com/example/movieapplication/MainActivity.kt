package com.example.movieapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapplication.core.viewmodel.MovieViewModel
import com.example.movieapplication.ui.presentation.navigation.NavGraph


class MainActivity : ComponentActivity() {
    private lateinit var viewModel : MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        setContent {
            val navController : NavHostController = rememberNavController()
            NavGraph(navController, viewModel = viewModel)
        }
    }
}
