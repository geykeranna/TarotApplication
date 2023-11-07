package ru.diploma.tarotapplication.ui.suits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.MainActivity
import ru.diploma.tarotapplication.ui.components.CustomIndicator
import ru.diploma.tarotapplication.ui.theme.BackgroundColor
import ru.diploma.tarotapplication.ui.theme.fontFamily
import javax.inject.Inject

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SuitsScreen(
    navController: NavController,
    viewModel: SuitsViewModel
) {
    val allCards = viewModel.tarotCardCollection.collectAsState().value
    val suits = viewModel.tarotCardByGroup.collectAsState().value
    val pagesItems = suits.map { it.value }

    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    Column {
        Text(
            modifier = Modifier
                .padding(top = 30.dp, bottom = 20.dp)
                .fillMaxWidth()
            ,
            text = allCards.name,
            fontFamily = fontFamily,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
        CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
            ScrollableTabRow(
                modifier = Modifier
                    .height(70.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 10.dp),
                selectedTabIndex = pagerState.currentPage,
                indicator = indicator,
                backgroundColor = BackgroundColor,
                divider = {}
            ) {
                pagesItems.forEachIndexed { index, item ->
                    Tab(
                        modifier = Modifier
                            .zIndex(6f)
                            .paint(painter = painterResource(viewModel.getIconSuitsID(item.first().suits_name))),
                        selected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerState.scrollToPage(index)
                            }
                        },
                    )
                }
            }
        }

        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundColor),
            count = pagesItems.size,
            state = pagerState,
        ) { page ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                item {
                    FlowRow(
                        modifier = Modifier.fillMaxSize(),
                        mainAxisSize = SizeMode.Expand,
                        mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly,
                        mainAxisSpacing = 10.dp
                    ) {
                        pagesItems[page].forEachIndexed { _, card ->
                            CardItem(
                                item = card,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }

}

object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f,0.0f,0.0f,0.0f)
}

@Composable
fun groupOfSuitsViewModel(
    systemId: Long
): SuitsViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as MainActivity,
        MainActivity.ViewModelFactoryProvider::class.java
    ).itemSuitsViewModelFactory()

    return viewModel(
        factory = SuitsViewModel.provideFactory(
            factory,
            systemId = systemId
        )
    )
}

class SuitsScreenFactory @Inject constructor() : NavigationScreenFactory {
    companion object Companion : NavigationFactory.NavigationFactoryCompanion {
        private const val SYSTEM_ID_KEY = "systemId"
    }

    override val factoryType: List<NavigationFactory.NavigationFactoryType>
        get() = listOf(NavigationFactory.NavigationFactoryType.Nested)

    override fun create(builder: NavGraphBuilder, navGraph: NavHostController) {
        builder.composable(
            route = "$route/{${
                SYSTEM_ID_KEY
            }}",
            arguments = listOf(navArgument(SYSTEM_ID_KEY) { type = NavType.LongType })
        ) {
            it.arguments?.getLong(SYSTEM_ID_KEY)?.let { systemId ->
                SuitsScreen(
                    navController = navGraph,
                    viewModel = groupOfSuitsViewModel(
                        systemId = systemId
                    )
                )
            }
        }
    }
}