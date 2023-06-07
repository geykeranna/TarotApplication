package ru.diploma.tarotapplication.domain.repositories

import ru.diploma.tarotapplication.data.model.GroupOfSuits

interface GroupOfSuitsRepository {

    suspend fun getGroupByID(id: Long) : List<GroupOfSuits>
}