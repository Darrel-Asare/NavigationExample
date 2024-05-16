package com.example.navigationexample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object DetailsScreen : Screen("details/{name}") {
        fun createRoute(name: String) = "details/$name"
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen")
        Button(
            onClick = { navController.navigate(Screen.DetailsScreen.createRoute("User")) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Go to Details Screen")
        }
    }
}

@Composable
fun DetailsScreen(name: String, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome $name")
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Go Back")
        }
    }
}