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
import ru.diploma.tarotapplication.data.model.GroupOfSuits
import ru.diploma.tarotapplication.domain.repositories.CardRepository
import ru.diploma.tarotapplication.ui.base.BaseEvent
import ru.diploma.tarotapplication.ui.base.BaseViewModel
import ru.diploma.tarotapplication.ui.suits.SuitsViewModel


class DetailCardViewModel @AssistedInject constructor(
    @Assisted
    private val cardId: Long,
    private val cardRepository: CardRepository
) : BaseViewModel<SuitsViewModel.Event>() {

    val cardData: StateFlow<Card>
        get() = _cardData.asStateFlow()

    private val _cardData = MutableStateFlow(Card.shimmerData)

    private fun startLoading(systemId: Long) = viewModelScope.launch {
        _cardData.emit(cardRepository.getCardByID(0))
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val cardId: Long) : Event()
    }

    override fun obtainEvent(event: SuitsViewModel.Event) {
        TODO("Not yet implemented")
    }

    @AssistedFactory
    interface Factory {
        fun create(
            walletId: Long
        ): DetailCardViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: DetailCardViewModel.Factory,
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