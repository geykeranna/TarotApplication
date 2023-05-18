package ru.diploma.tarotapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import ru.diploma.tarotapplication.data.model.Card
import ru.diploma.tarotapplication.data.model.Tags
import ru.diploma.tarotapplication.ui.screens.CardInfoScreen
import ru.diploma.tarotapplication.ui.theme.TarotApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarotApplicationTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
//                    LabelSearchComponents(label = "Tarot")
//                    SuitsScreen()

                    val card = Card(
                        card_id = 3,
                        card_number = 3,
                        card_name = "Card 1",
                        description = "All u need is money",
                        tag_id = listOf(
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            )
                        ),
                        category_id = listOf(
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            ),
                            Tags(
                                icon_id = R.drawable.cups,
                                tad_id = R.drawable.cups,
                                name = "Name",
                                value = "QWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGFQWERTYUIOPASDFGHJKLZXCVBNM,78954562123HGFDXCVBHGFDCVBNHGF"
                            )
                        ),
                        card_image = R.drawable.rider_waite_tarot_system
                    )
                    CardInfoScreen(card)
                }

            }
        }
    }
}