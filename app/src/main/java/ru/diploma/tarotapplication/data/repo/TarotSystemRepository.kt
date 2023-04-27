package ru.diploma.tarotapplication.data.repo

import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.TarotSystem

class TarotSystemRepository {
    fun getAllData() : List<TarotSystem>{
        return listOf(
            TarotSystem(
                id = 0,
                name = "Таро Уэйта",
                idImg = R.drawable.rider_waite_tarot_system
            ),
            TarotSystem(
                id = 1,
                name = "Таро Тотта",
                idImg = R.drawable.thoth_tarot_system
            )
        )

    }
}