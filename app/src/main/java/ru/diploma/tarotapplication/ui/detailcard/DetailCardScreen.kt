package ru.diploma.tarotapplication.ui.detailcard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import dagger.hilt.android.EntryPointAccessors
import ru.diploma.tarotapplication.TarotApplicationApp.Companion.context
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.MainActivity
import ru.diploma.tarotapplication.ui.detailcard.items.CardInfoLongItems
import ru.diploma.tarotapplication.ui.detailcard.items.CardInfoShortItems
import ru.diploma.tarotapplication.ui.theme.BackgroundColor
import javax.inject.Inject

@Composable
fun DetailCardScreen(
    viewModel: DetailCardViewModel
) {
    val card = viewModel.cardData.collectAsState().value

    val cardImgId = remember(card.card_image) {
        context?.resources?.getIdentifier(
            card.card_image,
            "drawable",
            context?.packageName
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(bottom = 20.dp, top = 40.dp),
            text = card.card_name,
            textAlign = TextAlign.Center,
            fontSize = 38.sp,
            color = Color.White
        )
        cardImgId?.let { painterResource(id = it) }?.let {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(vertical = 20.dp),
                painter = it,
                contentDescription = ""
            )
        }
        Text(
            text = card.description,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.White,
            fontStyle = FontStyle.Italic
        )

        LazyRow(
            modifier = Modifier
                .height(210.dp)
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 10.dp)
        ){
            items (items=card.tag_id) { tag ->
                CardInfoShortItems(tag = tag)
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(5.dp)
                .heightIn(min = 10.dp, max = 900.dp)
            ,
        ){
            items(items=card.category_id) {tag -> 
                CardInfoLongItems(tag = tag)
            }
        }
    }
}

@Composable
fun detailCardViewModel(
    cardId: Long
): DetailCardViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as MainActivity,
        MainActivity.ViewModelFactoryProvider::class.java
    ).itemCardViewModelFactory()

    return viewModel(
        factory = DetailCardViewModel.provideFactory(
            factory,
            cardId = cardId
        )
    )
}

class DetailCardScreenFactory @Inject constructor() : NavigationScreenFactory {
    companion object Companion : NavigationFactory.NavigationFactoryCompanion {
        private const val CARD_ID_KEY = "cardId"
    }

    override val factoryType: List<NavigationFactory.NavigationFactoryType>
        get() = listOf(NavigationFactory.NavigationFactoryType.Nested)

    override fun create(builder: NavGraphBuilder, navGraph: NavHostController) {
        builder.composable(
            route = "$route/{${
                CARD_ID_KEY
            }}",
            arguments = listOf(navArgument(CARD_ID_KEY) { type = NavType.LongType })
        ) {
            it.arguments?.getLong(CARD_ID_KEY)?.let { cardId ->
                DetailCardScreen(
                    viewModel = detailCardViewModel(
                        cardId = cardId
                    )
                )
            }
        }
    }
}