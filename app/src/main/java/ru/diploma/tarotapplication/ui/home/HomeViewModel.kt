package ru.diploma.tarotapplication.ui.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.diploma.tarotapplication.data.repo.TarotSystemRepository
import ru.diploma.tarotapplication.ui.base.BaseEvent
import ru.diploma.tarotapplication.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : BaseViewModel<HomeViewModel.Event>() {

    init {
        viewModelScope.launch {
            val repo = TarotSystemRepository().getAllData()
        }
    }

    override fun obtainEvent(event: Event) {
        TODO("Not yet implemented")
    }

    sealed class Event : BaseEvent() {

    }
}