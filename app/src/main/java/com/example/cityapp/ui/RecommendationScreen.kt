package com.example.cityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cityapp.model.Recommendation
import com.example.cityapp.CityViewModel
import com.example.cityapp.nav.Screen
import com.example.cityapp.nav.Screen.Screen.Info
import com.example.cityapp.model.CityUiState
import androidx.compose.foundation.lazy.items
import com.example.cityapp.datasource.DataSource
import com.example.cityapp.datasource.DataSource.categories


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationCard(
    navController: NavController,
    recommendation: Recommendation,
    modifier: Modifier = Modifier,
) {
    val cityViewModel: CityViewModel = viewModel()
    Card(
        modifier = modifier
            .padding(8.dp),
        onClick = {
            cityViewModel.updateCurrentRecommendation(recommendation)
            navController.navigate(Info.route)
        },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
        ) {
            Image(
                painter = painterResource(id = recommendation.image),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp, 80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = recommendation.name,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun Recommendation(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val cityViewModel: CityViewModel = viewModel()

    Scaffold(
        topBar = {
            RecommendationTitleBar(CityUiState.currentCategory.name, modifier)
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(CityUiState.currentCategory.recommendations) { recommendation ->
                RecommendationCard(
                    recommendation = recommendation,
                    navController = navController,
                    modifier = modifier
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationTitleBar(selectedCategoryName: String, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = selectedCategoryName,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        },
        modifier = modifier
    )
}


@Preview
@Composable
fun RecommendationPreview() {
    Recommendation(navController = rememberNavController(), modifier = Modifier)
}
