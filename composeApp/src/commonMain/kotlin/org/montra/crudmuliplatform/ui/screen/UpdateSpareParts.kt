package org.montra.crudmuliplatform.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.montra.crudmuliplatform.ui.viewmodel.UpdateSparePartsViewModel

class UpdateSpareParts : Screen {
    @Composable
    override fun Content() {
        updateScreen()
    }
}

@OptIn(KoinExperimentalAPI::class)
@Composable
fun updateScreen( viewModel: UpdateSparePartsViewModel = koinViewModel<UpdateSparePartsViewModel>()){

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Nombre / Número de serie",
            color = Color.Black,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        val searchText by viewModel.searchText.collectAsState()
        val sparePartList by viewModel.spareParts.collectAsState()
        val isSearching by viewModel.isSearching.collectAsState()

        OutlinedTextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            label = { Text(text = "Escriba aquí") },
            placeholder = { Text(text = "Nombre / Numero de serie") },
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.DarkGray,
                disabledTextColor = Color.LightGray,
                cursorColor = Color.Red,
                focusedIndicatorColor = Color.Red,
                focusedLabelColor = Color.Black
            ),
            keyboardActions = KeyboardActions(onSearch = {})
        )
    }

}



