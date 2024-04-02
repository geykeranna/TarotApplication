package ru.diploma.tarotapplication.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.R

val fontFamily = FontFamily(
    Font(R.font.ametist, FontWeight.Normal),
)

//val fontKreadonFamily = FontFamily(
//    Font(R.font.kreadon, FontWeight.Normal),
//)

val fontJejuMyeongjoFamily = FontFamily(
    Font(R.font.jejumyeongjo, FontWeight.Normal),
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fontJejuMyeongjoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 30.sp,
        color = TextColor
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)