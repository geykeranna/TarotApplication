package ru.diploma.tarotapplication.ui.items

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.diploma.tarotapplication.R

@Composable
fun SuitsItem() {
    val name = "Hide Arcan"
    Column(
        modifier = Modifier
            .padding(12.dp)
            .height(180.dp)
            .width(90.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Image(
            modifier = Modifier
                .height(160.dp),
            painter = painterResource(id = R.drawable.thoth_tarot_system),
            contentDescription = name
        )
        Text(
            text = name,
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SuitsItemPreview(){
    SuitsItem()
}