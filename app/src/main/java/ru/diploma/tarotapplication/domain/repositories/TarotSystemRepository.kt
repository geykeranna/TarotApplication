package ru.diploma.tarotapplication.domain.repositories

import ru.diploma.tarotapplication.data.model.TarotDecks

interface TarotSystemRepository {

    suspend fun getSystemList() : List<TarotDecks>
}