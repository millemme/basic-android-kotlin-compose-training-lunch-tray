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
import com.example.cityapp.model.Category
import com.example.cityapp.model.Recommendation


object DataSource {

    val coffeeRecommendations = listOf(
        Recommendation(
            name = "Kell's",
            address = "136 SW 2nd St, Corvallis, OR 97333",
            description = "The best coffee in town. The shop is a just a little walk up window so there is no seating, but the coffee, tea, and other drinks are the best Corvallis has to offer.",
            image = R.drawable.kells
        ),
            Recommendation(
                name = "Black Rock",
                address = "33144 OR-34, Albany, OR 97322",
                description = "One of my favorite drive through coffee chains. If you are looking for a flavored energy drink or a super sweet desert in a cup this is the place to go.",
                image = R.drawable.blackrock
            ),
            Recommendation(
                name = "Greenhouse Coffee + Plants",
                address = "308 SW Monroe Ave, Corvallis, OR 97333",
                description = "Greenhouse has the best atmosphere of any coffee shop in Corvallis. Really good coffee as well as a ton of plants to browse while you wait for your coffee or while you drink. Also has nice outdoor seating in the summertime.",
                image = R.drawable.greenhouse
            ),
            Recommendation(
                name = "Coffee Culture",
                address = "363 SW Jefferson Ave, Corvallis, OR 97333",
                description = "Good coffee with indoor seating. Also has pretty reasonable pricing and are very quick.",
                image = R.drawable.culture
            )
    )

    val mexicanRecommendations = listOf(
        Recommendation(
            name = "Oscar's Tacos and Cantina",
            address = "2475 NW 9th St, Corvallis, OR 97330",
            description = "Really good food with a bar and plenty of indoor seating. They are also one of the cheapest places to get mexican food.",
            image = R.drawable.oscar
        ),
        Recommendation(
            name = "El Patron",
            address = "1110 NE 2nd St, Corvallis, OR 97330",
            description = "The best mexican food in Corvallis but also one of the most expensive. Nice atmosphere with plenty of seating and a bar.",
            image = R.drawable.patron

        ),
        Recommendation(
            name = "Rivas Taco Shop",
            address = "360 NW 5th St, Corvallis, OR 97330",
            description = "Cheapest and fastest mexican food in Corvallis. They are also open really late unlike most businesses in Corvallis.",
            image = R.drawable.rivas

        ),
        Recommendation(
            name = "Delicias Valley Cafe",
            address = "933 NW Circle Blvd, Corvallis, OR 97330",
            description = "Best place to get breakfast burritos and they have some good outdoor seating.",
            image = R.drawable.valley
        )
    )
        val pizzaRecommendations = listOf(
            Recommendation(
                name = "Woodstocks",
                address = "1045 NW Kings Blvd, Corvallis, OR 97330",
                description = "Best dine in pizza place with some arcade machines and lots of seating. Really good pizza too.",
                image = R.drawable.woodstocks

            ),
            Recommendation(
                name = "Cirello's Pizza",
                address = "919 NW Circle Blvd F, Corvallis, OR 97330",
                description = "Best pizza in Corvallis but also one of the most expensive.",
                image = R.drawable.ciri
            ),
            Recommendation(
                name = "Market of Choice",
                address = " 922 NW Circle Blvd STE 110, Corvallis, OR 97330",
                description = "This is a grocery store, but they have some of the best NY style pizza in Corvallis. You can also buy them by the slice for a quick lunch.",
                image = R.drawable.market
            ),
            Recommendation(
                name = "American Dream Pizza",
                address = "2525 NW Monroe Ave, Corvallis, OR 97330",
                description = "This is some of the better cheap pizza in Corvallis with indoor seating. They are also right next to campus which is very convenient.",
                image = R.drawable.dream
            )
        )
    val coffeeCategory = Category(
        name = "Coffee Shop",
        image = R.drawable.coffee,
        recommendations = coffeeRecommendations
    )
    val mexicanCategory = Category(
    name = "Mexican Restaurant",
    image = R.drawable.taco,
        recommendations = mexicanRecommendations
    )
    val pizzaCategory = Category(
    name = "Pizza Restaurant",
    image = R.drawable.pizza,
        recommendations = pizzaRecommendations
    )

    val categories = listOf(coffeeCategory, mexicanCategory, pizzaCategory)
    }
