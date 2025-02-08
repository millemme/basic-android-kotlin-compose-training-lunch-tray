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
package com.example.cityapp.datasource

import com.example.cityapp.R
import com.example.cityapp.model.CityItem.CategoryItem
import com.example.cityapp.model.CityItem.RecommendationsItem

/**
 * Map of available menu items to be displayed in the menu fragments.
 */
object DataSource {

    val categoryItems = listOf(
        CategoryItem(
            name = "Coffee Shop",
            id = 1,
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipPaq2uii1z3zNmC0kOVOurtT7I7FEYM0b23et4y=s680-w680-h510"
        ),
        CategoryItem(
            name = "Mexican Restaurant",
            id = 2,
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipPkz_i6_wfvanXBJV1aM6cecaFYms6nKjYQUtAF=s680-w680-h510"
        ),
        CategoryItem(
            name = "Pizza Restaurant",
            id = 3,
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipPX6ZQCmLpX5fvZ7Tfjn8OJ4b617L-B1kp9upGE=s680-w680-h510"
        )
    )

    val recommendationsItems = mapOf(
        1 to listOf(
        RecommendationsItem(
            name = "Kell's",
            address = "136 SW 2nd St, Corvallis, OR 97333",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipPaq2uii1z3zNmC0kOVOurtT7I7FEYM0b23et4y=s680-w680-h510",
            id = 101,
            categoryId = 1
        ),
        RecommendationsItem(
            name = "Black Rock",
            address = "33144 OR-34, Albany, OR 97322",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipNPGRRI0_xUGnfs_Sy7OLWo9smidyeZewpNLAsf=s680-w680-h510",
            id = 102,
            categoryId = 1
        ),
        RecommendationsItem(
            name = "Greenhouse Coffee + Plants",
            address = "308 SW Monroe Ave, Corvallis, OR 97333",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipNGKTH8cH44mZhRjhc2_fvIcod2iIl1i-c73oNt=s680-w680-h510",
            id = 103,
            categoryId = 1
        ),
        RecommendationsItem(
            name = "Coffee Culture",
            address = "363 SW Jefferson Ave, Corvallis, OR 97333",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipMyLMOjy1bKqHLLAX9xBHEP6K05tjmFPYZPZv5D=s680-w680-h510",
            id = 104,
            categoryId = 1
        )
    ),

    2 to listOf(
        RecommendationsItem(
            name = "Oscar's Tacos and Cantina",
            address = "2475 NW 9th St, Corvallis, OR 97330",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipNQ6cf0QYrmG0gXSIlcoAYtaY43H1kJsTbp-aOe=s680-w680-h510",
            id = 201,
            categoryId = 2
        ),
        RecommendationsItem(
            name = "El Patron",
            address = "1110 NE 2nd St, Corvallis, OR 97330",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipN-cg4XhXcteJWN4RQoh5vNig2GqJz_fawwlSdE=s680-w680-h510",
            id = 202,
            categoryId = 2
        ),
        RecommendationsItem(
            name = "Rivas Taco Shop",
            address = "360 NW 5th St, Corvallis, OR 97330",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipPkz_i6_wfvanXBJV1aM6cecaFYms6nKjYQUtAF=s680-w680-h510",
            id = 203,
            categoryId = 2
        ),
        RecommendationsItem(
            name = "Delicias Valley Cafe",
            address = "933 NW Circle Blvd, Corvallis, OR 97330",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipNcJkGH6sI92M6BMa2gxsKzS7J3wfTVslCQ49IX=s680-w680-h510",
            id = 204,
            categoryId = 2
        )
    ),
        3 to listOf(
        RecommendationsItem(
            name = "Woodstocks",
            address = "1045 NW Kings Blvd, Corvallis, OR 97330",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipPX6ZQCmLpX5fvZ7Tfjn8OJ4b617L-B1kp9upGE=s680-w680-h510",
            id = 301,
            categoryId = 3
        ),
        RecommendationsItem(
            name = "Cirello's Pizza",
            address = "919 NW Circle Blvd F, Corvallis, OR 97330",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipP_-4MRmnArQ-sx780fCUCVWJZvz0h6v2TMGRz4=s680-w680-h510",
            id = 302,
            categoryId = 3
        ),
        RecommendationsItem(
            name = "Market of Choice",
            address = " 922 NW Circle Blvd STE 110, Corvallis, OR 97330",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipNs7dRYjQsNDdTtORx3-Y5CvkCcU0iYSTEaHZ0r=s680-w680-h510",
            id = 303,
            categoryId = 3
        ),
        RecommendationsItem(
            name = "American Dream Pizza",
            address = "2525 NW Monroe Ave, Corvallis, OR 97330",
            description = "String",
            imageRes = "https://lh3.googleusercontent.com/p/AF1QipPp3V3Z-o-qhEM0iVQr39mAzxt55C6TtRETpbds=s680-w680-h510",
            id = 304,
            categoryId = 3
        )
        )
    )}
