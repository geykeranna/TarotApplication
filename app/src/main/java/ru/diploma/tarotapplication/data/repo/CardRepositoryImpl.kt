package ru.diploma.tarotapplication.data.repo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.Utils.getJsonDataFromAsset
import ru.diploma.tarotapplication.data.model.Card
import ru.diploma.tarotapplication.data.model.InfoCard
import ru.diploma.tarotapplication.data.model.Tags
import ru.diploma.tarotapplication.data.model.TarotCardCollection
import ru.diploma.tarotapplication.domain.repositories.CardRepository
import java.io.IOException
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor() : CardRepository {

    override suspend fun getItemByID(id: Long): Card {
        var card: Card = Card.shimmerData
        try {
            val jsonFileString = getJsonDataFromAsset(id.toString())
            val gson = Gson()
            val listCardType = object : TypeToken<Card>() {}.type
            card = gson.fromJson(jsonFileString, listCardType)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        return card
    }
}