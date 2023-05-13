package ru.diploma.tarotapplication.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
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
import ru.diploma.tarotapplication.ui.theme.LightAccentColor

@Composable
fun SearchBar() {
    var value by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        value = value,
        onValueChange = { newText ->
            value = newText },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.White.copy(
                    alpha = ContentAlpha.medium
                )
            )
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close Icon",
                    tint = Color.White
                )
            }
        },
        shape = RoundedCornerShape(40.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = LightAccentColor,
            focusedBorderColor = LightAccentColor,
            cursorColor = LightAccentColor,
            textColor = Color.White
        )
    )
}