package org.montra.crudmuliplatform.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.montra.crudmuliplatform.data.model.SparePartModel
import org.montra.crudmuliplatform.ui.viewmodel.UpdateSparePartsViewModel

class UpdateSpareParts : Screen {
    @Composable
    override fun Content() {
        updateScreen()
    }
}

@OptIn(KoinExperimentalAPI::class)
@Composable
fun updateScreen(
    viewModel: UpdateSparePartsViewModel =
        koinViewModel<UpdateSparePartsViewModel>()
){
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    val spareParts by viewModel.filteredSpareParts.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Ingrese número de serie",
                fontSize = 15.sp,
                modifier = Modifier.fillMaxWidth(0.2f).wrapContentHeight(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(20.dp))

            OutlinedTextField(
                value = searchText,
                modifier = Modifier.fillMaxWidth(0.8f).widthIn(400.dp),
                onValueChange = viewModel::onSearchTextChange,
                label = { Text(text = "Numero de serie/parte") },
                placeholder = { Text(text = "Serial Number") },
                singleLine = true,
                maxLines = 1,
                shape = RoundedCornerShape(10.dp),
                keyboardActions = KeyboardActions(onSearch = {})
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { viewModel.onButtonSearchClick() },
            modifier = Modifier.fillMaxWidth(0.5f).widthIn(400.dp).height(50.dp),
            contentPadding = PaddingValues(4.dp)
        ){
            Text(
                text = "Validar SN",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

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
            ) {
                items(spareParts) { sparePart ->
                    spareCard(sparePart)
                }
            }
        }
    }


    /*
    if (search){
        OutlinedTextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            label = { Text(text = "Nombre del producto") },
            placeholder = { Text(text = "Product name") },
            enabled = true,
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            keyboardActions = KeyboardActions(onSearch = {})
        )
    }
    else{
        OutlinedTextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            label = { Text(text = "Escriba aquí") },
            placeholder = { Text(text = "Nombre") },
            enabled = false,
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            keyboardActions = KeyboardActions(onSearch = {})
        )
    }
    */
}

@Composable
private fun spareCard(sparePart: SparePartModel){
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        border = BorderStroke(1.dp, Color.Black),
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
        }
    }
}




