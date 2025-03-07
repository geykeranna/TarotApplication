package ru.diploma.tarotapplication.ui.detailcard

import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import coil.compose.AsyncImage
import dagger.hilt.android.EntryPointAccessors
import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.di.navigation.NavigationFactory
import ru.diploma.tarotapplication.di.navigation.NavigationScreenFactory
import ru.diploma.tarotapplication.ui.MainActivity
import ru.diploma.tarotapplication.ui.components.ExpandableCard
import ru.diploma.tarotapplication.ui.components.TabRowDefaults.Divider
import ru.diploma.tarotapplication.ui.components.TopBar
import ru.diploma.tarotapplication.ui.detailcard.items.CardInfoShortItems
import ru.diploma.tarotapplication.ui.theme.AccentColor
import ru.diploma.tarotapplication.ui.theme.BackgroundColor
import ru.diploma.tarotapplication.ui.utils.Constants.ASSETS_URL
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TopBar(
            title = if (card.short_description != "") "${card.card_name}. ${card.short_description}" else card.card_name,
            navController = navController,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 20.dp)
                .fillMaxWidth()
                .height(350.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(48.dp),
                painter = painterResource(id = R.drawable.elem4_img_left),
                contentDescription = null
            )
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .border(1.dp, AccentColor, RoundedCornerShape(15.dp))
                    .clickable {
                        cardState = !cardState
                        angle = (angle + 180) % 360f
                    }
                    .rotate(angle),
                backgroundColor = BackgroundColor

            ) {
                AsyncImage(
                    model = "${ASSETS_URL}/${card.card_image}.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .padding(all = 10.dp))
            }
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(48.dp),
                painter = painterResource(id = R.drawable.elem4_img_right),
                contentDescription = null
            )
        }
        if (card.description != ""){
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = card.description,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )
        }
        Divider(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            thickness = 1.dp,
            color = AccentColor
        )
        if(card.tag_id.isNotEmpty()) {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                mainAxisSize = SizeMode.Expand,
                mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly,
                mainAxisSpacing = 0.dp
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
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 9500.dp),
            userScrollEnabled = false,
        ){
            val items = if(cardState) card.category_id else card.category_id_reverse
            items(items=items) {tag ->
                ExpandableCard(
                    title = tag.name,
                    text = tag.value,
                    icon = viewModel.getIconCategoryID(tag.icon_id),
                    modifier = Modifier
                        .background(BackgroundColor)
                        .padding(vertical = 5.dp, horizontal = 10.dp))

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