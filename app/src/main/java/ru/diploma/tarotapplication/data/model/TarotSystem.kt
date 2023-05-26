package ru.diploma.tarotapplication.data.model

import ru.diploma.tarotapplication.R

data class TarotSystem(
    val id: Int,
    val name: String,
    val idImg: Int,
) {
    companion object {
        val shimmerData = listOf(
            TarotSystem(
                id = 1001,
                name = "Таро Уэйта",
                idImg = R.drawable.rider_waite_tarot_system
            ),
            TarotSystem(
                id = 1002,
                name = "Таро Тотта",
                idImg = R.drawable.thoth_tarot_system
            ),
            TarotSystem(
                id = 1003,
                name = "Таро Манара",
                idImg = R.drawable.manara_tarot_system
            )
        )
    }
}
