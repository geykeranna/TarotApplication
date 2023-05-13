package ru.diploma.tarotapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import ru.diploma.tarotapplication.ui.components.LabelSearchComponents
import ru.diploma.tarotapplication.ui.screens.SuitsScreen
import ru.diploma.tarotapplication.ui.theme.TarotApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarotApplicationTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    LabelSearchComponents(label = "Tarot")
                    SuitsScreen()
                }

            }
        }
    }
}