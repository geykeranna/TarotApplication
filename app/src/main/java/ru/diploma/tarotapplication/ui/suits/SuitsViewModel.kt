package ru.diploma.tarotapplication.ui.suits

import androidx.lifecycle.*
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.diploma.tarotapplication.data.model.InfoCard
import ru.diploma.tarotapplication.data.model.TarotCardCollection
import ru.diploma.tarotapplication.domain.repositories.GroupOfSuitsRepository
import ru.diploma.tarotapplication.ui.base.BaseEvent
import ru.diploma.tarotapplication.ui.base.BaseViewModel

class SuitsViewModel @AssistedInject constructor (
    @Assisted
    private val systemId: Long,
    private val groupOfSuitsRepository: GroupOfSuitsRepository,
) : BaseViewModel<SuitsViewModel.Event>() {

    val tarotCardCollection: StateFlow<TarotCardCollection>
        get() = _tarotCardCollectionData.asStateFlow()

    val tarotCardByGroup: StateFlow<Map<String, List<InfoCard>>>
        get() = _tarotCardByGroup.asStateFlow()

    private val _tarotCardCollectionData = MutableStateFlow(TarotCardCollection.shimmerData)
    private val _tarotCardByGroup = MutableStateFlow(mapOf<String, List<InfoCard>>())

    private fun startLoading(systemId: Long) = viewModelScope.launch {
        _tarotCardCollectionData.emit(groupOfSuitsRepository.getGroupByID(systemId))
        _tarotCardByGroup.emit(filterCardsByGroup(groupOfSuitsRepository.getGroupByID(systemId)))
    }

    private fun filterCardsByGroup(allCards: TarotCardCollection): Map<String, List<InfoCard>> {
        return allCards.cards_link.groupBy { it.suits_name }
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val systemId: Long) : Event()
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
        }
    }
}