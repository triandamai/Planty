package com.qamar.planty.data.model

import com.qamar.planty.R
import kotlin.random.Random


data class Plant(
    val name: String? = "",
    val properties: List<Properties> =
        listOf(
            Properties("Light"),
            Properties("Food"),
            Properties("Water"),
        ),
    val image: Int? = null
) {

    fun getPlantList(): List<Plant> {

        //"Bird of paradise", "Dracaena", "Palm", "Ficus", "Cedar", "Fiddle"
        return listOf(
            Plant("Bird of paradise",image = R.drawable.plant1),
            Plant("Dracaena",image = R.drawable.plant2),
            Plant("Palm",image = R.drawable.plant3),
            Plant("Ficus",image = R.drawable.plant1),
            Plant("Cedar",image = R.drawable.plant2),
            Plant("Fiddle",image = R.drawable.plant3),
        )
    }
}

data class Properties(
    val propertyName: String,
    val percent: Float = (0 until 100).random().toFloat()/100
)
