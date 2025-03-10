package ru.diploma.tarotapplication.ui.components

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import ru.diploma.tarotapplication.ui.theme.AccentColor
import ru.diploma.tarotapplication.ui.theme.DarkAccentColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage, label = "")

    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) spring(dampingRatio = 1f, stiffness = 50f)
            else spring(dampingRatio = 1f, stiffness = 1000f)
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) spring(dampingRatio = 1f, stiffness = 1000f)
            else spring(dampingRatio = 1f, stiffness = 50f)
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(0.dp)
            .fillMaxSize()
            .background(color = AccentColor, RoundedCornerShape(50))
            .border(BorderStroke(2.dp, DarkAccentColor), RoundedCornerShape(50))
            .zIndex(1f)
    )
}