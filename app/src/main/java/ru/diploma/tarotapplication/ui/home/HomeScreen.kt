package ru.diploma.tarotapplication.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.suits.NoRippleTheme
import javax.inject.Inject
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    mainViewModel: HomeViewModel = hiltViewModel()
) {
    val data = mainViewModel.systemData.collectAsState().value

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { data.size }
    )

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp)
                .height(55.dp),
            text = "Tarot",
            fontSize = 49.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                beyondBoundsPageCount = 3,
                pageSize = PageSize.Fixed(260.dp),
                pageSpacing = 2.dp,
                contentPadding = PaddingValues(horizontal = 62.dp),
            ) {page ->
                Card(
                    Modifier
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
                        .fillMaxWidth()
                        .height(440.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    TarotSystemCard(
                        tarotDecks = data[page],
                        navController = navController
                    )
                }
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