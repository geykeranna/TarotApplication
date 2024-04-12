package ru.diploma.tarotapplication.ui.suits

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch
import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.InfoCard
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.MainActivity
import ru.diploma.tarotapplication.ui.theme.BackgroundColor
import ru.diploma.tarotapplication.ui.components.CustomIndicator
import ru.diploma.tarotapplication.ui.components.CustomScrollableTabRow
import ru.diploma.tarotapplication.ui.components.TopBar
import javax.inject.Inject
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuitsScreen(
    navController: NavController,
    viewModel: SuitsViewModel
) {
    val allCards = viewModel.tarotCardCollection.collectAsState().value
    val suits = viewModel.tarotCardByGroup.collectAsState().value
    val pagesItems = suits.map { it.value }

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { suits.size }
    )
    val scope = rememberCoroutineScope()

    val indicator = @Composable { tabPositions: List<ru.diploma.tarotapplication.ui.components.TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    Column(
        modifier = Modifier.background(BackgroundColor)
    ) {
        TopBar(
            title = allCards.name,
            navController = navController,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.elem2_img),
                contentDescription = "",
                Modifier.size(30.dp)
            )
            CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                CustomScrollableTabRow(
                    modifier = Modifier
                        .height(50.dp)
                        .width(244.dp)
                        .padding(vertical = 0.dp, horizontal = 0.dp),
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
            Image(
                painter = painterResource(id = R.drawable.elem2_img),
                contentDescription = "",
                Modifier.size(30.dp)
            )
        }
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 5.dp)
                .background(color = BackgroundColor),
            state = pagerState,
        ) { page ->
            Card(
                backgroundColor = BackgroundColor,
                modifier = Modifier
                    .graphicsLayer {
                    val pageOffset =
                        ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 95.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    contentPadding = PaddingValues(horizontal = 5.dp)
                ){
                    items(
                        pagesItems[page]
                    ){card: InfoCard ->
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