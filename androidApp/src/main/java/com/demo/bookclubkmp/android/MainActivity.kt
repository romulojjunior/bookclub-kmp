package com.demo.bookclubkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.bookclubkmp.android.ui.AppRoute
import com.demo.bookclubkmp.android.ui.screens.auth.AuthViewModel
import com.demo.bookclubkmp.android.ui.screens.auth.SignInScreen
import com.demo.bookclubkmp.android.ui.screens.home.HomeScreen
import com.demo.bookclubkmp.android.ui.screens.home.HomeViewModel
import org.koin.android.ext.android.getKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = AppRoute.signInScreenPath
            ) {
                composable(AppRoute.signInScreenPath) {
                    val authViewModel = remember {
                        getKoin().get<AuthViewModel>()
                    }
                    MyApplicationTheme {
                        SignInScreen(
                            signIn = authViewModel::signIn,
                            uiState = authViewModel.uiState,
                            navigateToHome = {
                                navController.navigate(AppRoute.homeScreenPath) {
                                    popUpTo(AppRoute.signInScreenPath) { inclusive = true }
                                }
                            }
                        )
                    }
                }

                composable(AppRoute.homeScreenPath) {
                    val homeViewModel = remember {
                        getKoin().get<HomeViewModel>()
                    }
                    MyApplicationTheme {
                        HomeScreen(
                            uiState = homeViewModel.uiState,
                            searchUIState = homeViewModel.searchUIState,
                            loadFeatureBooks = homeViewModel::loadFeatureBooks,
                            loadRecommendedBooks = homeViewModel::loadRecommendedBooks,
                            loadFavoritesBooks = homeViewModel::loadFavoritesBooks,
                            searchBookByName = homeViewModel::searchBookByName)
                    }
                }
            }
        }
    }
}
