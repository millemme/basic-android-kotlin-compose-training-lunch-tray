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
package com.example.cityapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.cityapp.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.example.cityapp.model.CityItem
import com.example.cityapp.model.CityItem.CategoryItem
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.ui.platform.LocalContext
import java.sql.RowId
import com.example.cityapp.model.CityUiState

@Composable
fun BaseCityScreen(
    uiState: CityUiState,
    options: List<CityItem>,
    modifier: Modifier = Modifier,
    onRowClick: (Int) -> Unit,
    onClick: (CityItem) -> Unit
) {

    var selectedId: Int? by rememberSaveable { mutableStateOf(null) }

    Column(modifier = modifier) {
        uiState.categories.forEach { item ->

            CityItemRow(
                item = item,
                selected = uiState.currentRowId == item.id,
                onRowClick = { clickedItem ->

                    onRowClick(clickedItem.id)},
                    modifier = Modifier
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                    )
            )
        }
    }
}

@Composable
fun CityItemRow(
    selected: Boolean,
    item: CityItem,
    onRowClick: (CityItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .clickable{onRowClick(item)} ,

        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.headlineSmall
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.imageRes)
                    .crossfade(true)
                    .build(),
                modifier = Modifier.size(80.dp),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}


