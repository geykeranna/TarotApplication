package ru.diploma.tarotapplication.ui.detailcard

import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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
import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.TarotApplicationApp.Companion.context
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.MainActivity
import ru.diploma.tarotapplication.ui.components.ExpandableCard
import ru.diploma.tarotapplication.ui.detailcard.items.CardInfoShortItems
import ru.diploma.tarotapplication.ui.theme.BackgroundColor
import javax.inject.Inject

@SuppressLint("DiscouragedApi")
@Composable
fun DetailCardScreen(
    viewModel: DetailCardViewModel,
    navController: NavController
) {
    val card = viewModel.cardData.collectAsState().value

    // отслеживание положения карты: true - прямое, false - перевернутое
    var cardState by remember { mutableStateOf(true) }

    var angle by remember {
        mutableFloatStateOf(0f)
    }

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(bottom = 5.dp, top = 18.dp)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }.padding(horizontal = 10.dp),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "back button",
            )
            Text(
                text = if (card.short_description != "") "${card.card_name}. ${card.short_description}" else card.card_name,
                textAlign = TextAlign.Center,
                fontSize = 38.sp,
                color = Color.White,
            )
            Image(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(0.dp),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "",
            )
        }

        CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
            cardImgId?.let { painterResource(id = it) }?.let {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(270.dp)
                        .padding(vertical = 10.dp)
                        .clickable {
                            cardState = !cardState
                            angle = (angle + 180) % 360f
                        }
                        .rotate(angle),
                    painter = it,
                    contentDescription = ""
                )
            }
        }
        if (card.description != ""){
            Text(
                text = card.description,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.White,
                fontStyle = FontStyle.Italic
            )
        }

        if(card.tag_id.isNotEmpty()) {
            FlowRow(
                modifier = Modifier
                    .height(125.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp)
                    .padding(top = 20.dp, bottom = 1.dp),
                mainAxisSize = SizeMode.Expand,
                mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly,
                mainAxisSpacing = 10.dp
            ) {
                card.tag_id.forEach { tag ->
                    CardInfoShortItems(
                        tag = tag,
                        iconID = viewModel.getIconTagID(tag.icon_id))
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(5.dp)
                .heightIn(min = 100.dp, max = 900.dp),
            userScrollEnabled = false,
        ){
            val items = if(cardState) card.category_id else card.category_id_reverse
            items(items=items) {tag ->
                ExpandableCard(
                    title = tag.name,
                    text = tag.value,
                    icon = viewModel.getIconCategoryID(tag.icon_id))
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
                    ),
                    navController = navGraph,
                )
            }
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f,0.0f,0.0f,0.0f)
}