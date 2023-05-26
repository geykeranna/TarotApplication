package ru.diploma.tarotapplication.domain.repositories

import ru.diploma.tarotapplication.data.model.TarotSystem

interface TarotSystemRepository {

    suspend fun getSystemList() : List<TarotSystem>
}