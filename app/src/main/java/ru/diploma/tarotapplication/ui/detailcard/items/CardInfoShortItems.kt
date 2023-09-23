package ru.diploma.tarotapplication.ui.detailcard.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.Tags

@Composable
fun CardInfoShortItems(
    tag: Tags
){
    val iconsMap = mapOf(
        "major_arcana" to R.drawable.major_arcana,
        "zodiak_aquarius" to R.drawable.zodiak_aquarius,
        "element_wind" to R.drawable.element_wind,
        // TODO add icons
//        "element_fire" to R.drawable.element_fire,
//        "element_water" to R.drawable.element_water,
//        "element_earth" to R.drawable.element_earth,
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 10.dp)
            .width(100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally
    ) {
        iconsMap[tag.icon_id]?.let { painterResource(id = it) }?.let {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .padding(top = 10.dp),
                painter = it,
                contentDescription = tag.name
            )
        }
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