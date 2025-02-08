package com.example.cityapp.ui

/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.cityapp.model.CityItem.*
import com.example.cityapp.model.CityItem
import com.example.cityapp.model.CityUiState
import com.example.cityapp.datasource.DataSource
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        CityUiState(
            currentRowId = savedStateHandle.get<Int>("currentRowId") ?: 0,
            categories = DataSource.categoryItems
        )
    )
    val uiState: StateFlow<CityUiState> = _uiState.asStateFlow()

    fun setSelectedCategoryId(categoryId: Int) {
        savedStateHandle["currentRowId"] = categoryId
        _uiState.update { currentState ->
            currentState.copy(currentRowId = categoryId)
        }
    }

    fun updateCategory(selectedCategory: CategoryItem) {
        setSelectedCategoryId(selectedCategory.id)
        _uiState.update { currentState ->
            currentState.copy(currentCategory = selectedCategory)
        }
    }

    fun updateRecommendation(selectedRecommendations: RecommendationsItem) {
        _uiState.update { currentState ->
            currentState.copy(currentRecommendations = selectedRecommendations)
        }
    }

    fun updateCity(newItem: CityItem) {
        _uiState.update { currentState ->
            currentState.copy(
                currentCity = if (newItem is CityItem) newItem else currentState.currentCity
            )
        }
    }
}
