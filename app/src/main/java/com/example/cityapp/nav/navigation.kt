package com.example.cityapp.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cityapp.model.CityUiState
import com.example.cityapp.nav.Screen.Screen
import com.example.cityapp.nav.Screen.Screen.RecommendationScreen
import com.example.cityapp.nav.Screen.Screen.Info
import com.example.cityapp.ui.Recommendation
import com.example.cityapp.ui.CityApp
import com.example.cityapp.model.Recommendation
import com.example.cityapp.ui.RecommendationInfoScreen
import com.example.cityapp.CityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun Navigation(innerPadding: PaddingValues) {

    val navController = rememberNavController()
    val viewModel: CityViewModel = viewModel()
    NavHost(navController, startDestination = "baseCityScreen") {
        composable(Screen.BaseCityScreen.route) {
            CityApp(navController, viewModel, innerPadding)
        }
        composable(Screen.RecommendationScreen.route) {
            Recommendation(navController)
        }
        composable(Screen.Info.route) {
            RecommendationInfoScreen(navController = rememberNavController(), currentRecommendation = CityUiState.currentRecommendation)
        }
    }
}