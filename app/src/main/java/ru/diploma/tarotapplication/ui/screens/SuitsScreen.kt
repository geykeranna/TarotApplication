package ru.diploma.tarotapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import ru.diploma.tarotapplication.data.repo.GroupOfSuitsRepository
import ru.diploma.tarotapplication.ui.components.CustomIndicator
import ru.diploma.tarotapplication.ui.components.items.CardItem
import ru.diploma.tarotapplication.ui.theme.BackgroundColor

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SuitsScreen() {
    val suitsRepository = GroupOfSuitsRepository()
    val suits = suitsRepository.getAllData()

    val pagesItems = suits.map { it.name }

    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        ScrollableTabRow(
            modifier = Modifier
                .height(50.dp),
            selectedTabIndex = pagerState.currentPage,
            indicator = indicator,
            backgroundColor = BackgroundColor,
        ) {
            pagesItems.forEachIndexed { index, title ->
                Tab(
                    modifier = Modifier.zIndex(6f),
                    text = {
                        Text(
                            text = title,
                            color = Color.White
                        )
                    },
                    //TODO : сделать иконки вместо текста
//                    icon = {
//                           Icon(painter = painterResource(R.drawable.cups), contentDescription = null)
//                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.scrollToPage(index)
                        }
                    }
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
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                FlowRow(
                    modifier = Modifier.fillMaxSize(),
                    mainAxisSize = SizeMode.Expand,
                    mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly,
                    mainAxisSpacing = 10.dp
                ) {
                    suits[page].cardsLink.forEachIndexed { _, card ->
                        CardItem(item = card)
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

@Preview(showBackground = true)
@Composable
fun Screen(){
    SuitsScreen()
}