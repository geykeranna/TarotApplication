package ru.diploma.tarotapplication.ui.suits

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
            .height(200.dp)
            .width(80.dp)
            .clickable {
                navController.navigate(DetailCardScreenFactory.route + "/${item.card_id}")
            },
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        cardImgId?.let { painterResource(id = it) }?.let {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                painter = it,
                contentDescription = ""
            )
        }
        Text(
            modifier = Modifier.padding(horizontal = 1.dp),
            text = item.card_name,
            fontFamily = fontFamily,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}
