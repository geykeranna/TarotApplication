package ru.diploma.tarotapplication.ui.components.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.data.model.Card
import ru.diploma.tarotapplication.data.repo.GroupOfSuitsRepository
import ru.diploma.tarotapplication.ui.theme.LightAccentColor

@Composable
fun CardItem(item: Card){
    Column(
        modifier = Modifier
            .height(260.dp)
            .width(110.dp)
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 15.dp)
                .clip(shape = RoundedCornerShape(25.dp))
                .background(LightAccentColor),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(top = 10.dp),
                painter = painterResource(id = item.card_image),
                contentDescription = ""
            )
            Text(
                text = item.card_name,
                fontSize = 20.sp,
                color = Color.Black,
            )
        }

    }
}


@Composable
@Preview(showBackground = true)
fun CardView(){

    val suitsRepository = GroupOfSuitsRepository()
    val suits = suitsRepository.getAllData()

    CardItem(item = suits[0].cardsLink[0])
}