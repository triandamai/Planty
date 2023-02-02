package com.qamar.planty.data.model


data class Plant(
    val name: String? = "",
    val properties: List<Properties> =
        listOf(
            Properties("Light"),
            Properties("Food"),
            Properties("Water"),
        ),
) {

    fun getPlantList(): List<Plant> {

        //"Bird of paradise", "Dracaena", "Palm", "Ficus", "Cedar", "Fiddle"
        return listOf(
            Plant("Bird of paradise"),
            Plant("Dracaena"),
            Plant("Palm"),
            Plant("Ficus"),
            Plant("Cedar"),
            Plant("Fiddle"),
        )
    }
}

data class Properties(
    val propertyName: String,
    val percent: Float = (0 until 100).random().toFloat()/100
)
