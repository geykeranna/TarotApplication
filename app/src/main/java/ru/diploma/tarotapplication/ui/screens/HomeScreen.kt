package ru.diploma.tarotapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.diploma.tarotapplication.data.repo.TarotSystemRepository
import ru.diploma.tarotapplication.ui.components.items.TarotSystemItem

@Composable
fun HomeScreen() {
    val systemRepository = TarotSystemRepository()
    val data = systemRepository.getAllData()

    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(items=data) {system ->
            TarotSystemItem(tarotSystem = system)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen()
}