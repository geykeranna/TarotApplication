package ru.diploma.tarotapplication.data

import ru.diploma.tarotapplication.TarotApplicationApp.Companion.context
import java.io.IOException

object Utils {
    fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context?.assets?.open("$fileName.json")?.bufferedReader().use { it!!.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}