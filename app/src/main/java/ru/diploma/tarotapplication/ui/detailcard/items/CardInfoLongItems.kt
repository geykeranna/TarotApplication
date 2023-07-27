package ru.diploma.tarotapplication.ui.detailcard.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.data.model.Tags

@Composable
fun CardInfoLongItems(
    tag: Tags
){
    Row(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 8.dp, horizontal = 10.dp)
        .clip(shape = RoundedCornerShape(20.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(top = 10.dp, end = 20.dp),
            painter = painterResource(id = tag.icon_id),
            contentDescription = tag.name
        )
        Column(modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier.padding(bottom = 5.dp),
                text = tag.name,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                color = Color.White,
            )

            Text(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxHeight(),
                text = tag.value,
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                color = Color.White,
            )
        }


    }
}