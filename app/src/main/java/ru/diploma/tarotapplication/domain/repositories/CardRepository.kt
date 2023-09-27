package ru.diploma.tarotapplication.domain.repositories

import ru.diploma.tarotapplication.data.model.Card

interface CardRepository {
    suspend fun getItemByID(id: Long) : Card
}