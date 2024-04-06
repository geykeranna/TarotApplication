package ru.diploma.tarotapplication.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.ui.theme.AccentColor
import ru.diploma.tarotapplication.ui.theme.BackgroundColor
import ru.diploma.tarotapplication.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    modifier: Modifier,
    title: String,
    text: String,
    icon: Int
){
    var expandedState by remember { mutableStateOf(false) }

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .background(BackgroundColor)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .border(1.dp, AccentColor, RoundedCornerShape(15.dp)),
            shape = Shapes.medium,
            onClick = {
                expandedState = !expandedState
            }
        ) {
            Column(
                modifier = Modifier
                    .background(BackgroundColor)
                    .padding(vertical = 10.dp, horizontal = 15.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .size(60.dp)
                            .clip(CircleShape)
                            .border(1.dp, AccentColor, CircleShape),
                        backgroundColor = BackgroundColor
                    ) {
                        if (icon != 0) {
                            Image(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(4.dp),
                                painter = painterResource(id = icon),
                                contentDescription = title
                            )
                        }
                    }
                    Text(
                        modifier = Modifier.padding(start = 5.dp),
                        text = title,
                        textAlign = TextAlign.Start,
                        fontSize = 18.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (expandedState) {
                    Text(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxHeight()
                            .topBorder(2.dp, AccentColor)
                            .padding(top = 10.dp)
                            .padding(horizontal = 10.dp),
                        text = text,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.White,
                    )
                }
            }
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f,0.0f,0.0f,0.0f)
}

fun Modifier.topBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width - strokeWidthPx / 2
            drawLine(
                color = color,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = width, y = 0f),
                strokeWidth = strokeWidthPx,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
            )
        }
    }
)