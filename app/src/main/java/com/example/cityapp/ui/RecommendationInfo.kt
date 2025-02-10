package com.example.cityapp.ui

import com.example.cityapp.model.CityUiState
import com.example.cityapp.model.Recommendation
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cityapp.CityViewModel
import com.example.cityapp.nav.Screen
import com.example.cityapp.model.Category
import com.example.cityapp.nav.Screen.Screen.RecommendationScreen
import com.example.cityapp.nav.Screen.Screen.Info
import com.example.cityapp.nav.Screen.Screen.RecommendationScreen.route
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController



@Composable
fun RecommendationDetailsCard(recommendation: Recommendation, modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxSize()

    )
    {
        Spacer(modifier = modifier.height(25.dp))
        Image(
            painter = painterResource(id = recommendation.image),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
            .size(250.dp, 250.dp)
        )
        Spacer(modifier = modifier.height(25.dp))
        Text(
            text = recommendation.description,
            modifier = Modifier
                .padding(25.dp),
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationsDetailsTopAppBar(title: String, modifier: Modifier = Modifier, currentRecommendation: Recommendation, navController: NavController) {
    val cityViewModel: CityViewModel = viewModel()
    val backStackEntry by navController.currentBackStackEntryAsState()

    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically,) {
                Button(
                    modifier = Modifier,

                    onClick = {
                        navController.navigate("recommendationScreen"){
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                        //navController.navigateUp(backStackEntry)
                        //navController.navigate(backStackEntry)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "arrow back",
                        tint = Color.Black,
                        modifier = Modifier

                    )
                }
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = title,
                )
                Spacer(modifier = Modifier.width(200.dp))
            }
        }
    )
}

/*private fun cancelOrderAndNavigateToStart(
    viewModel: CityViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(CupcakeScreen.Start.name, inclusive = false)
}*/

@Composable
fun RecommendationInfoScreen(modifier: Modifier = Modifier, navController: NavController, currentRecommendation: Recommendation) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        RecommendationsDetailsTopAppBar(title = currentRecommendation.name, currentRecommendation = currentRecommendation, modifier = modifier, navController = navController)
        RecommendationDetailsCard(recommendation = currentRecommendation, modifier = modifier, navController)
    }
}


@Preview
@Composable
fun RecommendationCardPreview() {
    RecommendationInfoScreen(navController = rememberNavController(), currentRecommendation = CityUiState.currentRecommendation)
}