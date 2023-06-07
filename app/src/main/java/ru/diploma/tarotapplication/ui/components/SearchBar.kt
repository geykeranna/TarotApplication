package ru.diploma.tarotapplication.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.diploma.tarotapplication.ui.theme.AccentColor
import ru.diploma.tarotapplication.ui.theme.BackgroundColor
import ru.diploma.tarotapplication.ui.theme.DarkAccentColor
import ru.diploma.tarotapplication.ui.theme.LightAccentColor

@Composable
fun SearchBar() {
    var value by remember {
        mutableStateOf("")
    }

    var vectorColor by remember {
        mutableStateOf(BackgroundColor)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 40.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
        value = value,
        onValueChange = { newText ->
            value = newText },
        leadingIcon = {
            Icon(
                modifier = Modifier.padding(start = 15.dp),
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.White.copy(
                    alpha = ContentAlpha.medium
                )
            )
        },
        shape = RoundedCornerShape(40.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = DarkAccentColor,
            focusedBorderColor = LightAccentColor,
            cursorColor = LightAccentColor,
            textColor = Color.White
        )
    )
}