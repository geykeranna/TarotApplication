package ru.diploma.tarotapplication.ui.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.diploma.tarotapplication.data.model.TarotSystem
import ru.diploma.tarotapplication.data.repo.TarotSystemRepositoryImpl
import ru.diploma.tarotapplication.domain.repositories.TarotSystemRepository
import ru.diploma.tarotapplication.ui.base.BaseEvent
import ru.diploma.tarotapplication.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val systemRepository: TarotSystemRepository
) : BaseViewModel<HomeViewModel.Event>() {

    val systemData: StateFlow<List<TarotSystem>>
        get() = _systemData.asStateFlow()

    private val _systemData = MutableStateFlow(TarotSystem.shimmerData)

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    private fun startLoading() = viewModelScope.launch {
        _systemData.emit(systemRepository.getSystemList())
    }

    sealed class Event : BaseEvent() {
        object OnLoadingStarted : Event()
    }

    override fun obtainEvent(event: Event) {
        when(event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
        }
    }


}