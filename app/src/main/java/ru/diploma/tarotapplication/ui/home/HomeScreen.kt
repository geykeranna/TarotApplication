package ru.diploma.tarotapplication.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.suits.NoRippleTheme
import ru.diploma.tarotapplication.ui.theme.BackgroundColor
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Card{
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(BackgroundColor)
                ,
                painter = painterResource(id = R.drawable.header_img),
                contentDescription = ""
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 130.dp)
                    .background(BackgroundColor)
                    .height(55.dp),
                text = stringResource(id = R.string.app_name),
                fontSize = 49.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }

        data[pagerState.currentPage].description?.let {
            DescriptionRow(
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            )
        }

        CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(340.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                beyondBoundsPageCount = data.size,
                pageSize = PageSize.Fixed(180.dp),
                pageSpacing = 0.dp,
                contentPadding = PaddingValues(horizontal = 100.dp),
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
                        .width(195.dp)
                        .height(480.dp)
                        .padding(0.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    TarotSystemCard(
                        tarotDecks = data[page],
                        navController = navController,
                        modifier = Modifier.size(195.dp, 480.dp)
                    )
                }
            }
        }
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .background(BackgroundColor)
                .padding(0.dp)
        ) {
            Image(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(0.dp),
                painter = painterResource(id = R.drawable.footer_left),
                contentDescription = ""
            )
            Image(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(0.dp),
                painter = painterResource(id = R.drawable.footer_center),
                contentDescription = ""
            )
            Image(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(0.dp),
                painter = painterResource(id = R.drawable.footer_right),
                contentDescription = ""
            )
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