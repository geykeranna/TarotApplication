package ru.diploma.tarotapplication.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.ui.theme.BackgroundColor
import ru.diploma.tarotapplication.ui.theme.TextColor

@Composable
fun DescriptionRow(
    text: String = "",
    modifier: Modifier
){
    Row(
        modifier = modifier
            .background(BackgroundColor)
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(20.dp)
                .fillMaxHeight(),
            painter = painterResource(id = R.drawable.elem_img),
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 10.dp)
            ,
            lineHeight = 16.sp,
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = TextColor,
            textAlign = TextAlign.Center
        )
        Image(
            modifier = Modifier
                .width(20.dp)
                .fillMaxHeight(),
            painter = painterResource(id = R.drawable.elem_img),
            contentDescription = ""
        )
    }
}