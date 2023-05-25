package ru.diploma.tarotapplication.data.model

import ru.diploma.tarotapplication.R

data class Card(
    val id: Int,
    val card_number: Int,
    val card_name: String,
    val description: String,
    val tag_id: List<Tags>,
    val category_id: List<Tags>,
    val card_image: Int
) {
    companion object {
        val shimmerData = Card(
            id = 0,
            card_number = 1,
            card_name = "Card",
            description = "All u need is money",
            tag_id = listOf(
                Tags(
                    icon_id = 0,
                    tad_id = 0,
                    name = "   ",
                    value = "String"
                ),
                Tags(
                    icon_id = 0,
                    tad_id = 0,
                    name = "   ",
                    value = "String"
                ),
                Tags(
                    icon_id = 0,
                    tad_id = 0,
                    name = "   ",
                    value = "String"
                )
            ),
            category_id = listOf(
                Tags(
                    icon_id = 0,
                    tad_id = 0,
                    name = "   ",
                    value = "String"
                ),
                Tags(
                    icon_id = 0,
                    tad_id = 0,
                    name = "   ",
                    value = "String"
                ),
                Tags(
                    icon_id = 0,
                    tad_id = 0,
                    name = "   ",
                    value = "String"
                )
            ),
            card_image = R.drawable.rider_waite_tarot_system
        )
    }
}
