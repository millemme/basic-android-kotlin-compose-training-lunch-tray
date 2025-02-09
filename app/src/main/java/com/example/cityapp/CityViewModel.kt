package com.example.cityapp
import com.example.cityapp.model.CityUiState
import com.example.cityapp.model.Category
import com.example.cityapp.model.Recommendation
import androidx.lifecycle.ViewModel



class CityViewModel: ViewModel() {

    fun updateCurrentCategory(category: Category) {
        CityUiState.currentCategory = category
    }

    fun updateCurrentRecommendation(recommendation: Recommendation) {
        CityUiState.currentRecommendation = recommendation
    }
}