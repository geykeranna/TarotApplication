package ru.diploma.tarotapplication.data.model

import ru.diploma.tarotapplication.R

data class GroupOfSuits(
    val id: Long,
    val name: String,
    val idImg: Int,
    val cardsLink: List<Card>
)
{
    companion object {
        private var card = Card(
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
                )
            ),
            category_id = listOf(
                Tags(
                    icon_id = 0,
                    tad_id = 0,
                    name = "",
                    value = ""
                )
            ),
            category_id_reverse = listOf(
                Tags(
                    icon_id = 0,
                    tad_id = 0,
                    name = "",
                    value = ""
                )
            ),
            card_image = R.drawable.rider_waite_tarot_system
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


