package ru.diploma.tarotapplication.ui.detailcard.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.data.model.Tags

@Composable
fun CardInfoShortItems(
    tag: Tags,
    iconID: Int
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 4.dp)
            .width(110.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .padding(top = 10.dp),
            painter = painterResource(id = iconID),
            contentDescription = tag.name
        )
        Text(
            modifier = Modifier
                .padding(vertical = 1.dp),
            text = tag.name,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.Gray,
        )
        Text(
            modifier = Modifier
                .padding(vertical = 1.dp)
            ,
            text = tag.value,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.White,
        )
    }
}