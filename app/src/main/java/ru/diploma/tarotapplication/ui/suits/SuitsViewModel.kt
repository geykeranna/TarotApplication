package ru.diploma.tarotapplication.ui.suits

import androidx.lifecycle.*
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.diploma.tarotapplication.R
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

    private val iconsMap = mapOf(
        "major" to R.drawable.major_arcana,
        "cups" to R.drawable.cups,
        "swords" to R.drawable.swords,
        "wands" to R.drawable.wands,
        "coins" to R.drawable.coins,
        "element_water" to R.drawable.element_water,
        "element_fire" to R.drawable.element_fire,
        "element_wind" to R.drawable.element_wind,
        "element_earth" to R.drawable.element_earth
    )

    val tarotCardCollection: StateFlow<TarotCardCollection>
        get() = _tarotCardCollectionData.asStateFlow()

    val tarotCardByGroup: StateFlow<Map<String, List<InfoCard>>>
        get() = _tarotCardByGroup.asStateFlow()

    private val _tarotCardCollectionData = MutableStateFlow(TarotCardCollection.shimmerData)
    private val _tarotCardByGroup = MutableStateFlow(mapOf<String, List<InfoCard>>())

    fun getIconSuitsID(name: String) = iconsMap.getOrDefault(name, R.drawable.def)

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