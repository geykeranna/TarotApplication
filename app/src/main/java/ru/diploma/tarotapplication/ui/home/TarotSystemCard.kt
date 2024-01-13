package ru.diploma.tarotapplication.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.diploma.tarotapplication.data.model.TarotDecks
import ru.diploma.tarotapplication.ui.suits.SuitsScreenFactory

@Composable
fun TarotSystemCard(
    tarotDecks: TarotDecks,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(10.dp, 5.dp)
            .size(280.dp, 440.dp)
            .fillMaxSize()
            .clickable {
                navController.navigate(SuitsScreenFactory.route + "/${tarotDecks.id}")
            }
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier
                .height(380.dp)
                .width(200.dp)
                .size(80.dp)
                .padding(0.dp, 10.dp)
            ,
            alignment = Alignment.Center,
            painter = painterResource(id = tarotDecks.img_id),
            contentDescription = tarotDecks.name,
            contentScale = ContentScale.Crop
        )
        Text(
            text = tarotDecks.name,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
    }
}