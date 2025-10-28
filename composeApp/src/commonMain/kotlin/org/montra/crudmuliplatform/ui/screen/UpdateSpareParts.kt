package org.montra.crudmuliplatform.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.montra.crudmuliplatform.data.model.SparePartModel
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase
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
    val validation by viewModel.validation.collectAsState()
    val nombreProducto by viewModel.nombreProducto.collectAsState()
    val productName by viewModel.productName.collectAsState()
    val description by viewModel.description.collectAsState()
    val partNumber by viewModel.partNumber.collectAsState()
    val quantity by viewModel.quantity.collectAsState()
    val notes by viewModel.notes.collectAsState()

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current


    Column(
        modifier = Modifier.fillMaxWidth().padding(10.dp).background(
            if (isSystemInDarkTheme()) Color.Black else Color.White
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {

        Text(
            text = "Ingrese número de serie",
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = searchText,
            modifier = Modifier.fillMaxWidth(0.8f).widthIn(400.dp),
            onValueChange = viewModel::onSearchTextChange,
            enabled = !validation,
            label = { Text(text = "Numero de serie/parte") },
            placeholder = { Text(text = "Serial Number") },
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
        )


        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                viewModel.onButtonSearchClick()},
            modifier = Modifier.fillMaxWidth(0.5f).widthIn(400.dp).height(50.dp),
            contentPadding = PaddingValues(4.dp)
        ){
            Text(
                text = "Validar SN",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombreProducto,
            modifier =
                Modifier.fillMaxWidth(0.8f)
                    .widthIn(400.dp)
                    .focusRequester(focusRequester = focusRequester),
            onValueChange = viewModel::onNombreProductoTextChange,
            label = { Text(text = "Nombre del producto") },
            placeholder = { Text( text = "Nombre del producto en español" )},
            enabled = validation,
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = productName,
            modifier = Modifier.fillMaxWidth(0.8f).widthIn(400.dp),
            onValueChange = viewModel::onProductNameTextChange,
            label = { Text(text = "Product Name") },
            placeholder = { Text( text = "Nombre del producto en ingles" )},
            enabled = validation,
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = description,
            modifier = Modifier.fillMaxWidth(0.8f).widthIn(400.dp),
            onValueChange = viewModel::onDescriptionTextChange,
            label = { Text(text = "Descripción") },
            placeholder = { Text( text = "Descripción del producto" )},
            enabled = validation,
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = partNumber,
            modifier = Modifier.fillMaxWidth(0.8f).widthIn(400.dp),
            onValueChange = viewModel::onPartNumberTextChange,
            label = { Text(text = "Número de parte") },
            placeholder = { Text( text = "Número de parte" )},
            enabled = validation,
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = quantity,
            modifier = Modifier.fillMaxWidth(0.8f).widthIn(400.dp),
            onValueChange = viewModel::onQuantityTextChange,
            label = { Text(text = "Cantidad disponible") },
            placeholder = { Text( text = "Cantidad disponible" )},
            enabled = validation,
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = notes,
            modifier = Modifier.fillMaxWidth(0.8f).widthIn(400.dp),
            onValueChange = viewModel::onNotesTextChange,
            label = { Text(text = "Notas") },
            placeholder = { Text( text = "Notas" )},
            enabled = validation,
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )




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



}

@Composable
private fun spareCard(sparePart: SparePartModel){
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        colors = CardDefaults.cardColors(
            containerColor = RedColorBase.secondaryContainerLight,
            contentColor = RedColorBase.onSecondaryContainerLight,
        ),
        border = BorderStroke(1.dp, if (isSystemInDarkTheme()) RedColorBase.onSecondaryContainerDark else RedColorBase.onSecondaryContainerLight)
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




