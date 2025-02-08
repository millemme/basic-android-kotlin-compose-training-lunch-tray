package com.example.cityapp.model
data class CityUiState(
    // Entree Selection
    val currentCategory: CityItem.CategoryItem? = null,
    val currentCity: CityItem? = null,
    val currentRecommendations: CityItem.RecommendationsItem? = null,
    val currentRowId: Int? = null,
    val categories: List<CityItem.CategoryItem> = emptyList()
)
