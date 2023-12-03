package ru.diploma.tarotapplication.domain.repositories

import ru.diploma.tarotapplication.data.model.TarotCardCollection
import ru.diploma.tarotapplication.data.model.InfoCard

interface GroupOfSuitsRepository {

    suspend fun getGroupByID(id: Long) : TarotCardCollection
}