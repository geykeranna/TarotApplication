package ru.diploma.tarotapplication.data.model

data class Card(
    val id: Int,
    val card_number: Int,
    val card_name: String,
    val description: String,
    val tag_id: List<Tags>,
    val category_id: List<Tags>,
    val card_image: Int
)
