package ru.diploma.tarotapplication.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import ru.diploma.tarotapplication.di.navigation.NavigationHostFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.detailcard.DetailCardScreenFactory
import ru.diploma.tarotapplication.ui.home.HomeScreenFactory
import ru.diploma.tarotapplication.ui.main.MainNavHostScreenFactory
import ru.diploma.tarotapplication.ui.suits.SuitsScreenFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @IntoSet
    @Binds
    @Singleton
    fun bindMainNavHostScreenFactory(mainNavHostScreenFactory: MainNavHostScreenFactory): NavigationHostFactory

    @IntoSet
    @Binds
    @Singleton
    fun bindHomeScreenFactory(homeScreenFactory: HomeScreenFactory): NavigationScreenFactory

    @IntoSet
    @Binds
    @Singleton
    fun bindSuitsScreenFactory(suitsScreenFactory: SuitsScreenFactory): NavigationScreenFactory

    @IntoSet
    @Binds
    @Singleton
    fun bindDetailCardScreenFactory(detailCardScreenFactory: DetailCardScreenFactory): NavigationScreenFactory
}