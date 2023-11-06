package ru.diploma.tarotapplication.ui.detailcard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.Card
import ru.diploma.tarotapplication.domain.repositories.CardRepository
import ru.diploma.tarotapplication.ui.base.BaseEvent
import ru.diploma.tarotapplication.ui.base.BaseViewModel

class DetailCardViewModel @AssistedInject constructor(
    @Assisted
    private val cardId: Long,
    private val cardRepository: CardRepository
) : BaseViewModel<DetailCardViewModel.Event>() {

    private val iconsCategoryMap = mapOf(
        "default" to R.drawable.categ_default,
        "relations" to R.drawable.categ_relations,
        "work" to R.drawable.categ_work,
        "health" to R.drawable.categ_health,
        "person" to R.drawable.categ_person,
        "result" to R.drawable.categ_result,
        "finish" to R.drawable.categ_finish,
        "advice" to R.drawable.categ_advice,
        "warn" to R.drawable.categ_warn,
        "money" to R.drawable.categ_money,
        "keywords" to R.drawable.categ_keywords,
        "situation" to R.drawable.categ_situation,
        "location" to R.drawable.categ_location
    )

    private val iconsTagsMap = mapOf(
        "major_arcana" to R.drawable.major_arcana,
        "zodiac_aquarius" to R.drawable.zodiac_aquarius,
        "zodiac_aries" to R.drawable.zodiac_aries,
        "zodiac_taurus" to R.drawable.zodiac_taurus,
        "zodiac_cancer" to R.drawable.zodiac_cancer,
        "zodiac_leo" to R.drawable.zodiac_leo,
        "zodiac_virgo" to R.drawable.zodiac_virgo,
        "zodiac_libra" to R.drawable.zodiac_libra,
        "zodiac_scorpio" to R.drawable.zodiac_scorpio,
        "zodiac_sagittarius" to R.drawable.zodiac_sagittarius,
        "zodiac_gemini" to R.drawable.zodiac_gemini,
        "zodiac_pisces" to R.drawable.zodiac_pisces,
        "zodiac_capricorn" to R.drawable.zodiac_capricorn,
        "element_wind" to R.drawable.element_wind,
        "element_fire" to R.drawable.element_fire,
        "element_water" to R.drawable.element_water,
        "element_earth" to R.drawable.element_earth,
    )

    fun getIconCategoryID(name: String) = iconsCategoryMap.getOrDefault(name, R.drawable.def)

    fun getIconTagID(name: String) = iconsTagsMap.getOrDefault(name, R.drawable.def)

    val cardData: StateFlow<Card>
        get() = _cardData.asStateFlow()

    private val _cardData = MutableStateFlow(Card.shimmerData)

    private fun startLoading(cardId: Long) = viewModelScope.launch {
        _cardData.emit(cardRepository.getItemByID(cardId))
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading(cardId = event.cardId)
            }
        }
    }

    init {
        viewModelScope.launch {
            obtainEvent(Event.OnLoadingStarted(cardId = cardId))
        }
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val cardId: Long) : Event()
    }

    @AssistedFactory
    interface Factory {
        fun create(
            cardId: Long
        ): DetailCardViewModel
    }
    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            cardId: Long
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(
                    cardId
                ) as T
            }
        }
    }
}