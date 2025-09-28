//package com.example.movieapplication.ui.presentation.screens
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.outlined.Search
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalSoftwareKeyboardController
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.navigation.NavController
//import coil.compose.AsyncImage
//import coil.request.ImageRequest
//import com.example.movieapplication.core.viewmodel.MovieViewModel
//import com.example.movieapplication.core.models.Result
//
////import com.your.package.name.model.Result // <-- Import your Result data class
//
//@Composable
//fun ScreenA(navController: NavHostController, viewModel: MovieViewModel) {
//    // Collect the movies state in a lifecycle-aware manner
//    val movies by viewModel.movies.collectAsStateWithLifecycle()
//
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Column(modifier = Modifier.fillMaxSize()) {
//            SearchBar(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            )
//
//            // Display the list of movies
//            MovieList(movies = movies)
//        }
//    }
//}
//
//@Composable
//fun SearchBar(
//    modifier: Modifier = Modifier
//) {
//    var query by rememberSaveable { mutableStateOf("") }
//    val keyboardController = LocalSoftwareKeyboardController.current
//
//    OutlinedTextField(
//        value = query,
//        onValueChange = { query = it },
//        modifier = modifier,
//        label = { Text("Enter movie name") },
//        maxLines = 1,
//        singleLine = true,
//        trailingIcon = {
//            IconButton(
//                onClick = {
//                    if (query.isNotBlank()) {
//                        //onSearch(query)
//                        keyboardController?.hide() // Hide keyboard on search
//                    }
//                },
//                ) {
//                Icon(
//                    imageVector = Icons.Outlined.Search,
//                    contentDescription = "Search Button",
//                )
//            } },
////        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
////        keyboardActions = KeyboardActions(onSearch = {
////            if (query.isNotBlank()) {
////                //onSearch(query)
////                keyboardController?.hide() // Hide keyboard on search
////            }
////        })
//    )
//}
//
//@Composable
//fun MovieList(movies: List<Result>) {
//    if (movies.isEmpty()) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text("Search for similar movies!", style = MaterialTheme.typography.bodyLarge)
//        }
//    } else {
//        LazyColumn(
//            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            items(movies) { movie ->
//                MovieItem(movie = movie)
//            }
//        }
//    }
//}
//
//
//@Composable
//fun MovieItem(movie: Result) {
//    // The API provides a YouTube ID. We can construct a thumbnail URL from it.
//    val imageUrl = "https://img.youtube.com/vi/${movie.yID}/0.jpg"
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(120.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxSize(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            // Movie Thumbnail
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(imageUrl)
//                    .crossfade(true)
//                    .build(),
//                contentDescription = "${movie.name} thumbnail",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(100.dp)
//                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
//            )
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            // Movie Details
//            Column(
//                modifier = Modifier
//                    .weight(1f) // Takes remaining space
//                    .padding(end = 16.dp)
//            ) {
//                Text(
//                    text = movie.name,
//                    style = MaterialTheme.typography.titleMedium,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = movie.description, // wTeaser from API
//                    style = MaterialTheme.typography.bodySmall,
//                    maxLines = 3,
//                    overflow = TextOverflow.Ellipsis,
//                    color = MaterialTheme.colorScheme.onSurfaceVariant
//                )
//            }
//        }
//    }
//}

package com.example.movieapplication.ui.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapplication.core.viewmodel.MovieViewModel
import com.example.movieapplication.core.models.Result

//import com.your.package.name.model.Result // <-- Import your Result data class

//@Composable
//fun ScreenA(navController: NavHostController, viewModel: MovieViewModel) {
//    // Collect the movies state in a lifecycle-aware manner
//    val movies by viewModel.movies.collectAsStateWithLifecycle()
//    val isLoading by viewModel.movies.collectAsStateWithLifecycle()
//    val error by viewModel.movies.collectAsStateWithLifecycle()
//    val movieInfo by viewModel.movies.collectAsStateWithLifecycle()
//
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Column(modifier = Modifier.fillMaxSize()) {
//            SearchBar(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                viewModel
//            )
//
//            // Display the list of movies
//            MovieList(movies = movies)
//        }
//    }
//}
//
//@Composable
//fun SearchBar(
//    modifier: Modifier = Modifier,
//    viewModel: MovieViewModel
//) {
//    var query by rememberSaveable { mutableStateOf("") }
//    val keyboardController = LocalSoftwareKeyboardController.current
//
//    OutlinedTextField(
//        value = query,
//        onValueChange = { query = it },
//        modifier = modifier,
//        label = { Text("Enter movie name") },
//        maxLines = 1,
//        singleLine = true,
//        trailingIcon = {
//            IconButton(
//                onClick = {
//                    if (query.isNotBlank()) {
//                        viewModel.getMoviess(query)
//                        keyboardController?.hide() // Hide keyboard on search
//                    }
//                },
//            ) {
//                Icon(
//                    imageVector = Icons.Outlined.Search,
//                    contentDescription = "Search Button",
//                )
//            } },
////        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
////        keyboardActions = KeyboardActions(onSearch = {
////            if (query.isNotBlank()) {
////                //onSearch(query)
////                keyboardController?.hide() // Hide keyboard on search
////            }
////        })
//    )
//}
//
//@Composable
//fun MovieList(movies: List<Result>) {
//    if (movies.isEmpty()) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text("Search for similar movies!", style = MaterialTheme.typography.bodyLarge)
//        }
//    } else {
//        LazyColumn(
//            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            items(movies) { movie ->
//                MovieItem(movie = movie)
//            }
//        }
//    }
//}
//
//
//@Composable
//fun MovieItem(movie: Result) {
//    // The API provides a YouTube ID. We can construct a thumbnail URL from it.
//    val imageUrl = "https://img.youtube.com/vi/${movie.yID}/0.jpg"
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(120.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxSize(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            // Movie Thumbnail
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(imageUrl)
//                    .crossfade(true)
//                    .build(),
//                contentDescription = "${movie.name} thumbnail",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(100.dp)
//                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
//            )
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            // Movie Details
//            Column(
//                modifier = Modifier
//                    .weight(1f) // Takes remaining space
//                    .padding(end = 16.dp)
//            ) {
//                Text(
//                    text = movie.name,
//                    style = MaterialTheme.typography.titleMedium,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = movie.description, // wTeaser from API
//                    style = MaterialTheme.typography.bodySmall,
//                    maxLines = 3,
//                    overflow = TextOverflow.Ellipsis,
//                    color = MaterialTheme.colorScheme.onSurfaceVariant
//                )
//            }
//        }
//    }
//}





@Composable
fun ScreenA(
    navController: NavHostController,
    movieViewModel: MovieViewModel // Obtain ViewModel instance
) {
    // Collect states in a lifecycle-aware manner
    val movies by movieViewModel.movies.collectAsStateWithLifecycle()
    val isLoading by movieViewModel.isLoading.collectAsStateWithLifecycle()
    val error by movieViewModel.error.collectAsStateWithLifecycle()
    Surface(
            modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onSearch = { query ->
                    movieViewModel.getMoviess(query) // Call ViewModel function
                }
            )

            // Handle loading state
            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else if (error != null) {
                // Handle error state
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Error: $error",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            } else {
                // Display the list of movies
                MovieList(movies = movies)
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit // Callback to trigger search
) {
    var query by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        modifier = modifier,
        label = { Text("Enter movie name") },
        maxLines = 1,
        singleLine = true,
        trailingIcon = {
            IconButton(
                onClick = {
                    if (query.isNotBlank()) {
                        onSearch(query) // Call the onSearch lambda
                        keyboardController?.hide()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search Button",
                )
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            if (query.isNotBlank()) {
                onSearch(query) // Call the onSearch lambda
                keyboardController?.hide()
            }
        })
    )
}

@Composable
fun MovieList(movies: List<Result>) {
    if (movies.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Search for similar movies or no results found.", style = MaterialTheme.typography.bodyLarge)
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(movies) { movie ->
                MovieItem(movie = movie)
            }
        }
    }
}


@Composable
fun MovieItem(movie: Result) {
    val imageUrl = movie.yID?.let { "https://img.youtube.com/vi/${it}/0.jpg" } ?: "" // Handle nullable yID

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (imageUrl.isNotBlank()) { // Only display image if URL is valid
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "${movie.name} thumbnail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(100.dp)
                        .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                )
                Spacer(modifier = Modifier.width(16.dp))
            }


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp, start = if (imageUrl.isBlank()) 16.dp else 0.dp) // Adjust padding if no image
            ) {
                Text(
                    text = movie.name ?: "No Title", // Handle nullable name
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = movie.description ?: "No Description", // wTeaser from API, handle nullable
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}