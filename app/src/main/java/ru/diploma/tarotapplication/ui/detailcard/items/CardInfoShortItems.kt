package ru.diploma.tarotapplication.ui.detailcard.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.data.model.Tags

@Composable
fun CardInfoShortItems(
    tag: Tags
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 10.dp)
            .width(100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(top = 10.dp)
                .height(50.dp)
            ,
            contentScale = ContentScale.Crop,
            painter = painterResource(id = tag.icon_id),
            contentDescription = tag.name
        )
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp),
            text = tag.name,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.Gray,
        )
        Text(
            modifier = Modifier
                .padding(vertical = 5.dp)
            ,
            text = tag.value,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.White,
        )
    }
}