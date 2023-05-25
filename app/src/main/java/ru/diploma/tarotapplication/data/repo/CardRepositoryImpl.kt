package ru.diploma.tarotapplication.data.repo

import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.Card
import ru.diploma.tarotapplication.data.model.Tags
import ru.diploma.tarotapplication.domain.repositories.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(

) : CardRepository {

    private var card = Card(
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
    )

    override suspend fun getCardByID(id: Long): Card = card
}