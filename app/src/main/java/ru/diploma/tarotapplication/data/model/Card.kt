package ru.diploma.tarotapplication.data.model

import ru.diploma.tarotapplication.R

data class Card(
    val id: Long,
    val card_number: Int,
    val card_name: String,
    val description: String,
    val tag_id: List<Tags>,
    val category_id: List<Tags>,
    val category_id_reverse: List<Tags>,
    val card_image: Int
) {
    companion object {
        val shimmerData = Card(
            id = 0,
            card_number = 1,
            card_name = "",
            description = "",
            tag_id = listOf(
                Tags(
                    tad_id = 0,
                    icon_id = 0,
                    name = "",
                    value = ""
                ),
                Tags(
                    tad_id = 1,
                    icon_id = 0,
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
            category_id_reverse = listOf(
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
                    icon_id = R.drawable.major_arcana,
                    tad_id = 0,
                    name = "   ",
                    value = "String"
                )
            ),
            card_image = R.drawable.rider_waite_tarot_system
        )
    }
}
