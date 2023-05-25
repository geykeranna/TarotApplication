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
import ru.diploma.tarotapplication.data.model.GroupOfSuits
import ru.diploma.tarotapplication.domain.repositories.GroupOfSuitsRepository
import ru.diploma.tarotapplication.ui.base.BaseEvent
import ru.diploma.tarotapplication.ui.base.BaseViewModel

class SuitsViewModel @AssistedInject constructor (
    @Assisted
    private val systemId: Long,
    private val groupOfSuitsRepository: GroupOfSuitsRepository
    ) : BaseViewModel<SuitsViewModel.Event>() {

    val suitsData: StateFlow<List<GroupOfSuits>>
        get() = _groupOfSuitsData.asStateFlow()

    private val _groupOfSuitsData = MutableStateFlow(GroupOfSuits.shimmerData)

    private fun startLoading(walletId: Long) = viewModelScope.launch {
        _groupOfSuitsData.emit(groupOfSuitsRepository.getGroupByID(0))
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val systemId: Long) : Event()
    }

    @AssistedFactory
    interface Factory {
        fun create(
            walletId: Long
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
        TODO("Not yet implemented")
        when (event) {
            is Event.OnLoadingStarted -> {

            }
        }
    }
}