package ru.diploma.tarotapplication.data.model

data class Card(
    val id: Long,
    val card_number: Int,
    val card_name: String,
    val description: String,
    val short_description: String = "",
    val tag_id: List<Tags>,
    val category_id: List<Tags>,
    val category_id_reverse: List<Tags>,
    val card_image: String
){
    companion object {
        val shimmerData = Card(
            id = 0,
            card_number=0,
            card_name = "",
            short_description = "",
            description = "",
            tag_id = listOf(),
            category_id = listOf(),
            category_id_reverse = listOf(),
            card_image = ""
        )
    }
}