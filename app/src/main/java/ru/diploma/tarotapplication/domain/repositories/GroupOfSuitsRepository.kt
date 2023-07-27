package ru.diploma.tarotapplication.domain.repositories

import ru.diploma.tarotapplication.data.model.GroupOfSuits
import ru.diploma.tarotapplication.data.model.ShortCard

interface GroupOfSuitsRepository {

    suspend fun getGroupByID(id: Long) : List<GroupOfSuits>

    suspend fun getCardsBySearchString(name: String) : List<ShortCard>
}