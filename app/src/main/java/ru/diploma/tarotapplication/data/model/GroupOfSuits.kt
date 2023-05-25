package ru.diploma.tarotapplication.data.model

import ru.diploma.tarotapplication.R

data class GroupOfSuits(
    val id: Int,
    val name: String,
    val idImg: Int,
    val cardsLink: List<Card>
)
{
    companion object {
        private var cards = listOf<Card>(
            Card(
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
            ),
            Card(
                id = 2,
                card_number = 2,
                card_name = "Card 0",
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
            ),
            Card(
                id = 3,
                card_number = 3,
                card_name = "Card 1",
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
            ),
            Card(
                id = 4,
                card_number = 4,
                card_name = "Card 4",
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
            ),
            Card(
                id = 5,
                card_number = 5,
                card_name = "Card 5",
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
            ),

            )
        val shimmerData = listOf(
            GroupOfSuits(
                id = 4,
                name = "Старшие арканы",
                idImg = R.drawable.rider_waite_tarot_system,
                cardsLink = cards
            ),
            GroupOfSuits(
                id = 0,
                name = "Жезлы",
                idImg = R.drawable.rider_waite_tarot_system,
                cardsLink = cards
            ),
            GroupOfSuits(
                id = 1,
                name = "Кубки",
                idImg = R.drawable.rider_waite_tarot_system,
                cardsLink = cards
            ),
            GroupOfSuits(
                id = 2,
                name = "Мечи",
                idImg = R.drawable.rider_waite_tarot_system,
                cardsLink = cards
            ),
            GroupOfSuits(
                id = 3,
                name = "Пентакли",
                idImg = R.drawable.rider_waite_tarot_system,
                cardsLink = cards
            )
        )
    }
}


