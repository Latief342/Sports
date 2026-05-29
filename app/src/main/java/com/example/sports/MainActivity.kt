package com.example.sports

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sports.ui.screens.CatalogScreen
import com.example.sports.ui.screens.DetailScreen
import com.example.sports.ui.screens.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

val Context.dataStore by preferencesDataStore(name = "sports_preferences")

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // ViewModel diinjeksi secara otomatis oleh Hilt
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