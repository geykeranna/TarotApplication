package ru.diploma.tarotapplication.data.repo

import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.GroupOfSuits
import ru.diploma.tarotapplication.data.model.TarotSystem

class GroupOfSuitsRepository {
    fun getAllData() : List<GroupOfSuits>{
        return listOf(
            GroupOfSuits(
                id = 0,
                name = "Жезлы",
                idImg = R.drawable.rider_waite_tarot_system
            ),
            GroupOfSuits(
                id = 1,
                name = "Кубки",
                idImg = R.drawable.rider_waite_tarot_system
            ),
            GroupOfSuits(
                id = 2,
                name = "Мечи",
                idImg = R.drawable.rider_waite_tarot_system
            ),
            GroupOfSuits(
                id = 3,
                name = "Пентакли",
                idImg = R.drawable.rider_waite_tarot_system
            )
        )
    }
}