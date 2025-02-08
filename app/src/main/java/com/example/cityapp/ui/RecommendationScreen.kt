package com.example.cityapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cityapp.R
import com.example.cityapp.datasource.DataSource
import com.example.cityapp.model.CityItem
import com.example.cityapp.model.CityItem.CategoryItem
import com.example.cityapp.model.CityItem.RecommendationsItem
import androidx.compose.ui.platform.LocalContext
import com.example.cityapp.model.CityUiState

@Composable
fun RecommendationScreen(
    options: List<RecommendationsItem>,
            onClick: (CityItem) -> Unit,
    modifier: Modifier = Modifier,
    uiState: CityUiState,
    onRowClick: (Int) -> Unit
) {
    BaseCityScreen(
        uiState = CityUiState(),
        options = options,
        onClick = onClick,
        modifier = modifier,
        onRowClick = onRowClick,

    )
}

/*@Preview
@Composable
fun RecommendationsPreview(){
    RecommendationScreen(
        options = DataSource.recommendationsItems.,
        onClick = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
} */