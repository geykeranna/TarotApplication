package ru.diploma.tarotapplication.data.model

data class ShortCard(
    val id: Long,
    val id_card: Long,
    val card_number: Int,
    val card_name: String,
    val id_img: Int,
    val name_tarot_system: String = "tarot_system",
    val name_suits: String = "suits name",
) {
    companion object {
        val shimmerData = ShortCard(
            id = 0,
            id_card = 0,
            card_name = "",
            card_number = 0,
            id_img = 0,
            name_tarot_system = "",
            name_suits = "",
        )
    }
}
