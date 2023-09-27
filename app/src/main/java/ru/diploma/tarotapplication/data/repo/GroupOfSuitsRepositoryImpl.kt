package ru.diploma.tarotapplication.data.repo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.diploma.tarotapplication.data.Utils
import ru.diploma.tarotapplication.data.model.TarotCardCollection
import ru.diploma.tarotapplication.domain.repositories.GroupOfSuitsRepository
import javax.inject.Inject

class GroupOfSuitsRepositoryImpl @Inject constructor(
) : GroupOfSuitsRepository {

    override suspend fun getGroupByID(id: Long) : TarotCardCollection {
        val jsonFileString = Utils.getJsonDataFromAsset(id.toString())
        val gson = Gson()
        val listCardType = object : TypeToken<TarotCardCollection>() {}.type
        return gson.fromJson(jsonFileString, listCardType)
    }
}