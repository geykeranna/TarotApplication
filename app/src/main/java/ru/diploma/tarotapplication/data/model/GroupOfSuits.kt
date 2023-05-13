package ru.diploma.tarotapplication.data.model

data class GroupOfSuits(
    val id: Int,
    val name: String,
    val idImg: Int,
    val cardsLink: List<Card>
)
