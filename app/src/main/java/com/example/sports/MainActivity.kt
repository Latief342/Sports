package com.example.sports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    private val athleteViewModel: AthleteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportsAppNavigation(viewModel = athleteViewModel)
        }
    }
}

@Composable
fun SportsAppNavigation(viewModel: AthleteViewModel) {
    val navController = rememberNavController()

    // Perbaikan: Collect state dengan cara yang benar di Compose
    val athletes by viewModel.athletes.collectAsState()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                onNavigateToCatalog = { navController.navigate("catalog") }
            )
        }

        composable("catalog") {
            CatalogScreen(
                viewModel = viewModel,
                onAthleteClick = { athlete ->
                    navController.navigate("detail/${athlete.name}")
                }
            )
        }

        composable("detail/{athleteName}") { backStackEntry ->
            val athleteName = backStackEntry.arguments?.getString("athleteName")

            // Perbaikan: Hapus .value dan langsung gunakan variabel athletes yang sudah di-collect
            val athlete = athletes.find { it.name == athleteName }

            if (athlete != null) {
                DetailScreen(
                    athlete = athlete,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}