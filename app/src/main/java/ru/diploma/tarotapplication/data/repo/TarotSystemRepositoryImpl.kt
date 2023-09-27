package ru.diploma.tarotapplication.data.repo

import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.TarotDecks
import ru.diploma.tarotapplication.domain.repositories.TarotSystemRepository
import javax.inject.Inject

class TarotSystemRepositoryImpl @Inject constructor(

) : TarotSystemRepository {

    override suspend fun getSystemList(): List<TarotDecks> {
        return listOf(
            TarotDecks(
                id = 1001,
                name = "Таро Уэйта",
                img_id = R.drawable.rider_waite_tarot_system
            ),
            TarotDecks(
                id = 1002,
                name = "Таро Тотта",
                img_id = R.drawable.thoth_tarot_system
            ),
            TarotDecks(
                id = 1003,
                name = "Таро Манара",
                img_id = R.drawable.manara_tarot_system
            )
        )
    }
}