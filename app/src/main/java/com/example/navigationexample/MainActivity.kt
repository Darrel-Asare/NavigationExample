package com.example.navigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationexample.ui.theme.NavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    androidx.navigation.compose.NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(Screen.HomeScreen.route) {
                            HomeScreen(navController)
                        }
                        composable(
                            route = Screen.DetailsScreen.route,
                            arguments = listOf(navArgument("name") { defaultValue = "Guest" })
                        ) { backStackEntry ->
                            DetailsScreen(
                                name = backStackEntry.arguments?.getString("name") ?: "Guest",
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}