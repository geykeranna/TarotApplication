package ru.diploma.tarotapplication.ui.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.diploma.tarotapplication.data.extentions.filter
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationHostFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.home.HomeScreenFactory
import javax.inject.Inject

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainNavHostScreen(
    modifier: Modifier,
    navigationFactoryList: List<NavigationFactory>,
) {
    val controller = rememberNavController()

    Scaffold(
        modifier = modifier,
    ) {
        NavHost(
            navController = controller,
            startDestination = HomeScreenFactory.route
        ) {
            navigationFactoryList
                .forEach {
                    it.create(this, controller)
                }
        }
    }
}

class MainNavHostScreenFactory @Inject constructor(
    private val navigationFactorySet: @JvmSuppressWildcards Set<NavigationScreenFactory>
) : NavigationHostFactory {

    companion object Companion : NavigationFactory.NavigationFactoryCompanion

    override val factoryType: List<NavigationFactory.NavigationFactoryType>
        get() = listOf(NavigationFactory.NavigationFactoryType.Main)

    override fun create(builder: NavGraphBuilder, navGraph: NavHostController) {
        builder.composable(route = route) {
            MainNavHostScreen(
                modifier = Modifier,
                navigationFactoryList = navigationFactorySet
                    .filter(NavigationFactory.NavigationFactoryType.Nested)
            )
        }
    }
}