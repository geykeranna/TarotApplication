package ru.diploma.tarotapplication.data.repo

import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.TarotSystem
import ru.diploma.tarotapplication.domain.repositories.TarotSystemRepository

class TarotSystemRepositoryImpl : TarotSystemRepository {

    override suspend fun getSystemList(): List<TarotSystem> {
        return listOf(
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