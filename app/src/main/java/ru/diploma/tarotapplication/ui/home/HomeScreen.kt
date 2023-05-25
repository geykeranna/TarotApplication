package ru.diploma.tarotapplication.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ru.diploma.tarotapplication.data.repo.TarotSystemRepository
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import javax.inject.Inject

@Composable
fun HomeScreen(
    navController: NavController,
    mainViewModel: HomeViewModel = hiltViewModel()
) {
    val systemRepository = TarotSystemRepository()
    val data = systemRepository.getAllData()

    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(items=data) {system ->
            TarotSystemItem(
                tarotSystem = system,
                navController = navController
            )
            /* TODO НАВИГАЦИЯ С ITEM */
        }
    }
}

class HomeScreenFactory @Inject constructor() : NavigationScreenFactory {
    companion object Companion : NavigationFactory.NavigationFactoryCompanion

    override val factoryType: List<NavigationFactory.NavigationFactoryType>
        get() = listOf(NavigationFactory.NavigationFactoryType.Nested)

    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        builder.composable(route = route) {
            HomeScreen(navController)
        }
    }
}