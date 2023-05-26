package ru.diploma.tarotapplication.data.model

import ru.diploma.tarotapplication.R

data class GroupOfSuits(
    val id: Long,
    val name: String,
    val idImg: Int,
    val cardsLink: List<ShortCard>
)
{
    companion object {
        private var card = ShortCard(
            id = 0,
            id_card = 0,
            card_number = 0,
            card_name = "",
            id_img = 0,
        )

        val shimmerData = listOf(
            GroupOfSuits(
                id = 4,
                name = "Старшие арканы",
                idImg = R.drawable.major_arcana,
                cardsLink = listOf(card)
            ),
            GroupOfSuits(
                id = 0,
                name = "Жезлы",
                idImg = R.drawable.wands,
                cardsLink = listOf(card)
            ),
            GroupOfSuits(
                id = 1,
                name = "Кубки",
                idImg = R.drawable.cups,
                cardsLink = listOf(card)
            ),
            GroupOfSuits(
                id = 2,
                name = "Мечи",
                idImg = R.drawable.rider_waite_tarot_system,
                cardsLink = listOf(card)
            ),
            GroupOfSuits(
                id = 3,
                name = "Пентакли",
                idImg = R.drawable.pentacles,
                cardsLink = listOf(card)
            )
        )
    }
}


