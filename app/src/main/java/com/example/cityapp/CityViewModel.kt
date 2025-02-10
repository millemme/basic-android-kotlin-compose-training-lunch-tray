package com.example.cityapp
import com.example.cityapp.model.CityUiState
import com.example.cityapp.model.Category
import com.example.cityapp.model.Recommendation
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class CityViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CityUiState())
    val uiState: StateFlow<CityUiState> = _uiState.asStateFlow()

    fun updateCurrentCategory(category: Category) {
        _uiState.update { currentState -> currentState.copy(currentCategory = category) }
        CityUiState.currentCategory = category

    }

    fun updateCurrentRecommendation(recommendation: Recommendation) {
        _uiState.update { currentState -> currentState.copy(currentRecommendation = recommendation) }
        CityUiState.currentRecommendation = recommendation
    }

    fun getCurrentCategory(): Category? {
        return uiState.value.currentCategory
    }
}
