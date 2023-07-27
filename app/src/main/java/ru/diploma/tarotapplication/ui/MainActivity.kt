package ru.diploma.tarotapplication.ui

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import ru.diploma.tarotapplication.data.extentions.filter
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationHostFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.detailcard.DetailCardViewModel
import ru.diploma.tarotapplication.ui.navigation.NavItem
import ru.diploma.tarotapplication.ui.search.SearchViewModel
import ru.diploma.tarotapplication.ui.suits.SuitsViewModel
import ru.diploma.tarotapplication.ui.theme.TarotApplicationTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationScreenFactorySet: @JvmSuppressWildcards Set<NavigationScreenFactory>

    @Inject
    lateinit var navigationHostFactorySet: @JvmSuppressWildcards Set<NavigationHostFactory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarotApplicationTheme {
                val navController = rememberNavController()
                Surface {
                    NavHost(
                        navController = navController,
                        startDestination = NavItem.MainScreen.route
                    ) {
                        mutableSetOf<NavigationFactory>().apply {
                            addAll(
                                navigationScreenFactorySet
                                    .filter(NavigationFactory.NavigationFactoryType.Main)
                            )
                            addAll(
                                navigationHostFactorySet
                                    .filter(NavigationFactory.NavigationFactoryType.Main)
                            )
                        }.forEach {
                            it.create(this, navController)
                        }
                    }
                }
            }
        }
    }

    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface ViewModelFactoryProvider {
        fun itemSuitsViewModelFactory(): SuitsViewModel.Factory

        fun itemCardViewModelFactory(): DetailCardViewModel.Factory

        fun itemSearchViewModelFactory(): SearchViewModel.Factory
    }
}