package ru.diploma.tarotapplication.ui.detailcard.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.data.model.Tags
import ru.diploma.tarotapplication.ui.theme.AccentColor
import ru.diploma.tarotapplication.ui.theme.BackgroundColor

@Composable
fun CardInfoShortItems(
    tag: Tags,
    iconID: Int
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 1.dp)
            .width(100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(1.dp, AccentColor, CircleShape),
            backgroundColor = BackgroundColor
        ) {
            Image(
                modifier = Modifier
                    .padding(4.dp),
                painter = painterResource(id = iconID),
                contentDescription = tag.name
            )
        }
        Text(
            modifier = Modifier
                .padding(vertical = 1.dp),
            text = tag.name,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
        )
        Text(
            modifier = Modifier
                .padding(vertical = 1.dp)
            ,
            text = tag.value,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = Color.White,
            lineHeight = 16.sp
        )
    }
}