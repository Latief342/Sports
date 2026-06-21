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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sports.ui.LoginScreen
import com.example.sports.ui.ProfileScreen
import com.example.sports.ui.RegisterScreen
import com.example.sports.ui.screens.CatalogScreen
import com.example.sports.ui.screens.DetailScreen
import dagger.hilt.android.AndroidEntryPoint

val Context.dataStore by preferencesDataStore(
    name = "sports_preferences"
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val athleteViewModel: AthleteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SportsAppNavigation(
                viewModel = athleteViewModel
            )
        }
    }
}

@Composable
fun SportsAppNavigation(
    viewModel: AthleteViewModel
) {

    val navController = rememberNavController()

    val athletes by viewModel.athletes.collectAsState()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // LOGIN
        composable("login") {

            val authViewModel: AuthViewModel =
                hiltViewModel()

            LoginScreen(

                authViewModel = authViewModel,

                onLoginSuccess = {

                    navController.navigate("catalog") {

                        popUpTo("login") {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                },

                onRegisterClick = {
                    navController.navigate("register")
                }
            )
        }

        // REGISTER
        composable("register") {

            val authViewModel: AuthViewModel =
                hiltViewModel()

            RegisterScreen(

                authViewModel = authViewModel,

                onBackToLogin = {
                    navController.popBackStack()
                }
            )
        }

        // CATALOG
        composable("catalog") {

            CatalogScreen(

                viewModel = viewModel,

                onAthleteClick = { athlete ->

                    navController.navigate(
                        "detail/${athlete.name}"
                    )
                },

                onProfileClick = {
                    navController.navigate("profile")
                }
            )
        }

        // PROFILE
        composable("profile") {

            val authViewModel: AuthViewModel =
                hiltViewModel()

            ProfileScreen(

                authViewModel = authViewModel,

                onLogoutClick = {

                    authViewModel.logout()

                    navController.navigate("login") {

                        popUpTo(0)

                        launchSingleTop = true
                    }
                }
            )
        }

        // DETAIL
        composable("detail/{athleteName}") { backStackEntry ->

            val athleteName =
                backStackEntry.arguments?.getString(
                    "athleteName"
                )

            val athlete =
                athletes.find {
                    it.name == athleteName
                }

            if (athlete != null) {

                DetailScreen(

                    athlete = athlete,

                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}