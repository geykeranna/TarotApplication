package ru.diploma.tarotapplication.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import javax.inject.Inject

@Composable
fun HomeScreen(
    navController: NavController,
    mainViewModel: HomeViewModel = hiltViewModel()
) {
    val data = mainViewModel.systemData.collectAsState().value

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp)
                .height(40.dp),
            text = "Tarot",
            fontSize = 49.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        LazyColumn(
            contentPadding = PaddingValues(all = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(items=data) {system ->
                TarotSystemItem(
                    tarotDecks = system,
                    navController = navController
                )
            }
        }
    }

}

class HomeScreenFactory @Inject constructor() : NavigationScreenFactory {
    companion object Companion : NavigationFactory.NavigationFactoryCompanion

    override val factoryType: List<NavigationFactory.NavigationFactoryType>
        get() = listOf(NavigationFactory.NavigationFactoryType.Nested)

    override fun create(builder: NavGraphBuilder, navGraph: NavHostController) {
        builder.composable(route = route) {
            HomeScreen(navGraph)
        }
    }
}