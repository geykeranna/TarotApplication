package ru.diploma.tarotapplication.ui.suits

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
import ru.diploma.tarotapplication.domain.repositories.GroupOfSuitsRepository
import ru.diploma.tarotapplication.ui.base.BaseEvent
import ru.diploma.tarotapplication.ui.base.BaseViewModel

class SuitsViewModel @AssistedInject constructor (
    @Assisted
    private val systemId: Long,
    private val groupOfSuitsRepository: GroupOfSuitsRepository,
    // private val cardRepository: CardRepository
) : BaseViewModel<SuitsViewModel.Event>() {

    val suitsData: StateFlow<List<GroupOfSuits>>
        get() = _groupOfSuitsData.asStateFlow()

//    val cardItem: StateFlow<Card>
//        get() = _cardItem.asStateFlow()

    private val _groupOfSuitsData = MutableStateFlow(GroupOfSuits.shimmerData)
    // private val _cardItem = MutableStateFlow(Card.shimmerData)

    private fun startLoading(systemId: Long) = viewModelScope.launch {
        _groupOfSuitsData.emit(groupOfSuitsRepository.getGroupByID(systemId))
    }

//    private fun loadCardInfo(cardId: Long) = viewModelScope.launch {
//        _cardItem.emit(cardRepository.getCardByID(cardId))
//    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val systemId: Long) : Event()

        // class OnLoadingCardInfo(val cardId: Long) : Event()
    }

    init {
        obtainEvent(Event.OnLoadingStarted(systemId))
    }

    @AssistedFactory
    interface Factory {
        fun create(
            systemId: Long
        ): SuitsViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            systemId: Long
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(
                    systemId
                ) as T
            }
        }
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading(systemId = event.systemId)
            }
//            is Event.OnLoadingCardInfo -> {
//                loadCardInfo(cardId = event.cardId)
//            }
        }
    }
}