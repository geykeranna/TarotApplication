package ru.diploma.tarotapplication.ui.navigation

import androidx.annotation.DrawableRes
import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.ui.main.MainNavHostScreenFactory

sealed class NavItem(val route: String) {

    object MainScreen : NavItem(MainNavHostScreenFactory.route)

//    enum class NavArrItems(
//        val route: String,
//        val nestedRoute: List<String>
//    ) {
//        NewItem(
//            Hme
//        )
//    }

    /* TODO */
}