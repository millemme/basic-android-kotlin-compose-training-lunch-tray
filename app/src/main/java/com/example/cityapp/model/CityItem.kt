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
package com.example.cityapp.model

sealed class CityItem(
    open val name: String,
    open val id: Int,
    open val imageRes: String
) {
    data class CategoryItem (
        override val id: Int,
        override val name: String,
        override val imageRes: String
    ) : CityItem(name, id, imageRes)

    data class RecommendationsItem (
        override val name: String,
        val address: String,
        val description: String,
        override val imageRes: String,
        override val id: Int,
        val categoryId: Int
    ) : CityItem(name, id, imageRes)

}
