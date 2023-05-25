package ru.diploma.tarotapplication.ui.suits

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.diploma.tarotapplication.data.model.Card
import ru.diploma.tarotapplication.ui.detailcard.DetailCardScreenFactory
import ru.diploma.tarotapplication.ui.theme.LightAccentColor

@Composable
fun CardItem(
    item: Card,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .height(260.dp)
            .width(110.dp)
            .padding(vertical = 10.dp)
            .clickable {
                navController.navigate(DetailCardScreenFactory.route + "/${item.id}")
            },
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
        ) {
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
