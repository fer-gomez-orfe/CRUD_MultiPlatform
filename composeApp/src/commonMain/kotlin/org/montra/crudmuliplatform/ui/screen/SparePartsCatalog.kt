package org.montra.crudmuliplatform.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.montra.crudmuliplatform.data.model.SparePartModel
import org.montra.crudmuliplatform.ui.viewmodel.SparePartsCatalogViewModel


class SparePartsCatalog: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){

            SparePartsScreen()
        }
    }
}


@OptIn(KoinExperimentalAPI::class)
@Composable
fun SparePartsScreen(
    viewModel: SparePartsCatalogViewModel = koinViewModel<SparePartsCatalogViewModel>()
){
    
    val searchText by viewModel.searchText.collectAsState()
    val sparePartList by viewModel.spareParts.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if(isSearching) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(sparePartList) { sparePart ->
                    itemCard(sparePart)
                }
            }
        }
    }

}

@Composable
fun itemCard(sparePart: SparePartModel){
    Card(
        elevation = 6.dp,
        modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(vertical = 10.dp, horizontal = 20.dp),
        border = BorderStroke(1.dp, Color.Black),
        backgroundColor = Color(0xFFFFFFF0)

    ){
        Column(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Row {
                Text(text = "Item: ", fontWeight = FontWeight.Bold)
                Text(sparePart.item_Eng)
            }
            Row {
                Text(text = "Item: ", fontWeight = FontWeight.Bold)
                Text(sparePart.item_Esp)
            }
            Row {
                Text(text = "Descripción: ", fontWeight = FontWeight.Bold)
                Text(sparePart.description)
            }
            Row {
                Text(text = "Part Number: ", fontWeight = FontWeight.Bold)
                Text(sparePart.part_number)
            }
            Row {
                Text(text = "Serial Number: ", fontWeight = FontWeight.Bold)
                Text(sparePart.serial_number)
            }
            Row {
                Text(text = "Cantidad: ", fontWeight = FontWeight.Bold)
                Text(sparePart.cantidad.toString())
            }
            Row {
                Text(text = "Notas: ", fontWeight = FontWeight.Bold)
                Text(sparePart.notas)
            }
            Row {
                Text(text = "Fecha de actualización: ", fontWeight = FontWeight.Bold)
                Text(sparePart.ult_actualizacion)
            }

        }
    }
}
