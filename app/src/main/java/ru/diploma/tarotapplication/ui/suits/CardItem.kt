package ru.diploma.tarotapplication.ui.suits

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.diploma.tarotapplication.TarotApplicationApp
import ru.diploma.tarotapplication.data.model.InfoCard
import ru.diploma.tarotapplication.ui.detailcard.DetailCardScreenFactory
import ru.diploma.tarotapplication.ui.theme.fontFamily

@Composable
fun CardItem(
    item: InfoCard,
    navController: NavController
) {
    val cardImgId = remember(item.img_id) {
        TarotApplicationApp.context?.resources?.getIdentifier(
            item.img_id,
            "drawable",
            TarotApplicationApp.context?.packageName
        )
    }
    Column(
        modifier = Modifier
            .height(240.dp)
            .width(110.dp)
            .padding(vertical = 2.dp)
            .clickable {
                navController.navigate(DetailCardScreenFactory.route + "/${item.card_id}")
            },
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp)
                .clip(shape = RoundedCornerShape(25.dp)),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            cardImgId?.let { painterResource(id = it) }?.let {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .padding(top = 10.dp),
                    painter = it,
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 3.dp),
                text = item.card_name,
                fontStyle = FontStyle.Italic,
                fontFamily = fontFamily,
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}
