package ru.diploma.tarotapplication.ui.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T : BaseEvent?> : ViewModel() {

    abstract fun obtainEvent(event: T)
}

abstract class BaseEvent