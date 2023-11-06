package ru.diploma.tarotapplication.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    title: String,
    text: String,
    icon: Int
){
    var expandedState by remember { mutableStateOf(false) }

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 5.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            shape = Shapes.medium,
            onClick = {
                expandedState = !expandedState
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (icon != 0) {
                        Image(
                            modifier = Modifier
                                .size(60.dp)
                                .padding(end = 20.dp),
                            painter = painterResource(id = icon),
                            contentDescription = title
                        )
                    }
                    Text(
                        modifier = Modifier.padding(start = 5.dp),
                        text = title,
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (expandedState) {
                    Text(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .padding(horizontal = 5.dp)
                            .fillMaxHeight(),
                        text = text,
                        textAlign = TextAlign.Start,
                        fontSize = 18.sp,
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