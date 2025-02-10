package com.example.cityapp.nav

class Screen {
    sealed class Screen(val route: String) {
        object BaseCityScreen : Screen("baseCityScreen")
        object RecommendationScreen: Screen("recommendationScreen")
        object Info: Screen("info")
    }
}