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
import ru.diploma.tarotapplication.data.model.Card
import ru.diploma.tarotapplication.domain.repositories.CardRepository
import ru.diploma.tarotapplication.ui.base.BaseEvent
import ru.diploma.tarotapplication.ui.base.BaseViewModel

class DetailCardViewModel @AssistedInject constructor(
    @Assisted
    private val cardId: Long,
    private val cardRepository: CardRepository
) : BaseViewModel<DetailCardViewModel.Event>() {

    val cardData: StateFlow<Card>
        get() = _cardData.asStateFlow()

    private val _cardData = MutableStateFlow(Card.shimmerData)

    private fun startLoading(cardId: Long) = viewModelScope.launch {
        _cardData.emit(cardRepository.getCardByID(cardId))
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