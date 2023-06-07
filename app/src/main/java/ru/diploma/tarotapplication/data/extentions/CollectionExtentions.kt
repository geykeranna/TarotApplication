package ru.diploma.tarotapplication.data.extentions

import ru.diploma.tarotapplication.di.navigation.NavigationFactory

fun Set<NavigationFactory>.filter(vararg filters: NavigationFactory.NavigationFactoryType): List<NavigationFactory> {
    val rezList = mutableListOf<NavigationFactory>()
    filters.forEach { type ->
        rezList.addAll(this.filter { it.factoryType.contains(type) })
    }
    return rezList.toList()
}