package ru.diploma.tarotapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import ru.diploma.tarotapplication.R
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.data.model.Card
import ru.diploma.tarotapplication.ui.components.items.CardInfoLongItems
import ru.diploma.tarotapplication.ui.components.items.CardInfoShortItems
import ru.diploma.tarotapplication.ui.theme.BackgroundColor

@Composable
fun CardInfoScreen(card: Card) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            //TODO onClick
            IconButton(onClick = {  }){
                Icon(
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = "",
                    tint = Color.White
                )
            }
            IconButton(onClick = {  }){
                Icon(
                    painter = painterResource(R.drawable.ic_favourite),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(vertical = 20.dp),
            text = "${card.card_number} ${card.card_name}",
            textAlign = TextAlign.Center,
            fontSize = 38.sp,
            color = Color.White
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(vertical = 20.dp),
            painter = painterResource(id = card.card_image),
            contentDescription = "")
        Text(
            text = card.description,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.White,
            fontStyle = FontStyle.Italic
        )

        LazyRow(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(vertical = 40.dp, horizontal = 10.dp)
        ){
            items (items=card.tag_id) { tag ->
                CardInfoShortItems(tag = tag)
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
                .heightIn(min=10.dp, max=900.dp)
            ,
        ){
            items(items=card.category_id) {tag -> 
                CardInfoLongItems(tag = tag)
            }
        }
    }
}