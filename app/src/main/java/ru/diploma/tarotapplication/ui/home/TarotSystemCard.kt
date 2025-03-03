package ru.diploma.tarotapplication.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.diploma.tarotapplication.data.model.TarotDecks
import ru.diploma.tarotapplication.ui.suits.SuitsScreenFactory

@Composable
fun TarotSystemCard(
    tarotDecks: TarotDecks,
    navController: NavController,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .padding(0.dp)
            .fillMaxSize()
            .clickable {
                navController.navigate(SuitsScreenFactory.route + "/${tarotDecks.id}")
            }
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = modifier
                .fillMaxSize()
                .padding(0.dp, 0.dp)
                .clip(RoundedCornerShape(10.dp))
            ,
            alignment = Alignment.Center,
            painter = painterResource(id = tarotDecks.img_id),
            contentDescription = tarotDecks.name,
            contentScale = ContentScale.Crop
        )
    }
}