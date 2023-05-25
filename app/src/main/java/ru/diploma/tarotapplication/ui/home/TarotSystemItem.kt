package ru.diploma.tarotapplication.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import ru.diploma.tarotapplication.data.model.TarotSystem
import ru.diploma.tarotapplication.ui.suits.SuitsScreenFactory
import ru.diploma.tarotapplication.ui.theme.BackgroundItemColor

@Composable
fun TarotSystemItem(
    tarotSystem: TarotSystem,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(BackgroundItemColor)
            .clickable {
                navController.navigate(SuitsScreenFactory.route + "/${tarotSystem.id}")
            }
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Spacer(modifier = Modifier.width(3.dp))
        Image(
            modifier = Modifier
                .size(40.dp, 40.dp)
                .clip(CircleShape),
            painter = painterResource(id = tarotSystem.idImg),
            contentDescription = tarotSystem.name,
            contentScale = ContentScale.Crop
        )
        Text(
            text = tarotSystem.name,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.weight(1f))

        Icon(
            Icons.Rounded.Favorite,
            tint = Color.Red,
            contentDescription = "Favorite Icon")

        Spacer(modifier = Modifier.width(3.dp))
    }
}