package ru.diploma.tarotapplication.data.model

data class TarotCardCollection(
    val id: Long,
    val name: String,
    val cards_link: List<InfoCard>
){
    companion object {
        val shimmerData = TarotCardCollection(
            id = 0,
            name = "",
            cards_link = listOf()
        )
    }
}