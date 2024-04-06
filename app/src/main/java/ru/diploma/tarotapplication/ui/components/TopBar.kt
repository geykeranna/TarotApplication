package ru.diploma.tarotapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.diploma.tarotapplication.R

@Composable
fun TopBar(
    modifier: Modifier,
    isBack: Boolean = true,
    title: String = "",
    navController: NavController? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(bottom = 5.dp, top = 24.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(isBack && navController != null){
            Image(
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    }
                    .size(20.dp),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "back button",
            )
        }
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 36.sp,
        )

    }
}