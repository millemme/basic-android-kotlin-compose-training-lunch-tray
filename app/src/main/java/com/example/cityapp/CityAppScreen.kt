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
package com.example.cityapp

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cityapp.datasource.DataSource
import com.example.cityapp.ui.CategoryScreen
import com.example.cityapp.ui.CityViewModel
import com.example.cityapp.ui.BaseCityScreen
import com.example.cityapp.ui.RecommendationScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle

enum class CityAppScreen(@StringRes val title: Int = R.string.Corvallis) {
    Start(title = R.string.Corvallis),
    Category,
    Recommendations
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun CityAppApp() {
    //Create NavController
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = CityAppScreen.valueOf(
        backStackEntry?.destination?.route ?: CityAppScreen.Start.name
    )
    // Create ViewModel
    val viewModel: CityViewModel = viewModel()

    Scaffold(
        topBar = {
            CityAppAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val cityUiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = CityAppScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = CityAppScreen.Start.name) {
                CategoryScreen(
                    uiState = cityUiState,
                    options = DataSource.categoryItems,
                    onRowClick = { item ->
                        viewModel.updateCurrentRowId(item)
                    },
                    onClick = {item ->
                        viewModel.updateCity(item)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())

                )
            }

            composable(route = CityAppScreen.Recommendations.name) {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                val selectedCategoryId = uiState.currentRowId
                val recommendations = selectedCategoryId?.let { categoryId ->
                    DataSource.recommendationsItems[categoryId] ?: emptyList()
                } ?: emptyList()
                RecommendationScreen(
                    uiState = uiState,
                    onRowClick = { item ->
                        viewModel.updateCurrentRowId(item)
                    },
                    options = recommendations,
                    onClick = { item ->
                        viewModel.updateCity(item)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                )
            }


/*
            composable(route = CityAppScreen.Checkout.name) {
                CheckoutScreen(
                    orderUiState = uiState,
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(CityAppScreen.Start.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(CityAppScreen.Start.name, inclusive = false)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium),
                        )
                )
            }*/
        }
            }
        }