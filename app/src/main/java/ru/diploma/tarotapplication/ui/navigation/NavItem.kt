package ru.diploma.tarotapplication.ui.navigation

import ru.diploma.tarotapplication.ui.main.MainNavHostScreenFactory

sealed class NavItem(val route: String) {

    object MainScreen : NavItem(MainNavHostScreenFactory.route)

}