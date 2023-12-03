package ru.diploma.tarotapplication.data.model

data class InfoCard(
    val card_id: Long,
    val card_number: Int,
    val card_name: String,
    val img_id: String,
    val suits_name: String,
)