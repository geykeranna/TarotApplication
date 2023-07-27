package ru.diploma.tarotapplication.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.diploma.tarotapplication.data.model.ShortCard
import ru.diploma.tarotapplication.ui.base.BaseEvent
import ru.diploma.tarotapplication.ui.base.BaseViewModel

class SearchViewModel @AssistedInject constructor (
    // @Assisted
    // private val repository: GroupOfSuitsRepository
) : BaseViewModel<SearchViewModel.Event>() {

    val labelString: StateFlow<String>
        get() = _labelStating.asStateFlow()

    val searchString: StateFlow<String>
        get() = _searchString.asStateFlow()

    val searchResult: StateFlow<List<ShortCard>>
        get() = _searchResult.asStateFlow()

    private val _labelStating = MutableStateFlow("")
    private val _searchString = MutableStateFlow("")
    private val _searchResult = MutableStateFlow(listOf(ShortCard.shimmerData))

    private fun startLoading() = viewModelScope.launch {
        _labelStating.emit("Справочник Таро")
    }

//    private fun searchString(name: String) = viewModelScope.launch {
//        val results = groupOfSuitsRepository.getCardsBySearchString(name)
//        _searchResult.emit(results)
//    }

    private fun setSearchString(name: String) = viewModelScope.launch {
        _searchString.emit(name)
    }

    private fun setLabel(name: String) = viewModelScope.launch {
        _searchString.emit(name)
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> { startLoading() }
            // is Event.OnEnterSearchString -> { searchString(event.search) }
            is Event.OnSetLabel -> { setLabel(event.label) }
        }
    }

    sealed class Event : BaseEvent() {
        object OnLoadingStarted : Event()

        // class OnEnterSearchString(val search: String) : Event()

        class OnSetLabel(val label: String) : Event()
    }

    @AssistedFactory
    interface Factory {
        fun create(): SearchViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create() as T
            }
        }
    }

}