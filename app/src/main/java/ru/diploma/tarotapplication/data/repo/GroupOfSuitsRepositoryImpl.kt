package ru.diploma.tarotapplication.data.repo

import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.Card
import ru.diploma.tarotapplication.data.model.GroupOfSuits
import ru.diploma.tarotapplication.data.model.Tags
import ru.diploma.tarotapplication.domain.repositories.CardRepository
import ru.diploma.tarotapplication.domain.repositories.GroupOfSuitsRepository
import javax.inject.Inject

class GroupOfSuitsRepositoryImpl @Inject constructor(

) : GroupOfSuitsRepository {

    override suspend fun getGroupByID(id: Long) : List<GroupOfSuits> {
        return listOf()
    }
}