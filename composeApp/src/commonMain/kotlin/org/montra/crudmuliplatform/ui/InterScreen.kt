package org.montra.crudmuliplatform.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase
import org.montra.crudmuliplatform.ui.screen.SparePartsCatalog
import org.montra.crudmuliplatform.ui.screen.UpdateSpareParts

class InterScreen: Screen {
    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxSize().background(
            if (isSystemInDarkTheme()) Color.Black else Color.White
        ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            buttonViewAll()
            Spacer(modifier = Modifier.height(20.dp))
            buttonUpdate()
            Spacer(modifier = Modifier.height(20.dp))
            buttonLogOut()
        }
    }
}


@Composable
fun buttonViewAll(){
    val navigator = LocalNavigator.current
    Button(
        onClick = { navigator?.push(SparePartsCatalog())},
        modifier = Modifier.fillMaxWidth(0.6f).widthIn(max = 300.dp),
        contentPadding = PaddingValues(10.dp),
    ){
        Text(fontSize = 20.sp,text = "Ver Catalogo")
    }
}

@Composable
fun buttonUpdate(){
    val navigator = LocalNavigator.current
    Button(
        onClick = { navigator?.push(UpdateSpareParts())},
        modifier = Modifier.fillMaxWidth(0.6f).widthIn(max = 300.dp),
        contentPadding = PaddingValues(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor =
                if (isSystemInDarkTheme()) RedColorBase.secondaryDark else RedColorBase.secondaryLight,
            contentColor =
                if (isSystemInDarkTheme()) RedColorBase.onSecondaryDark else RedColorBase.onSecondaryLight
        )
    ){
        Text(fontSize = 20.sp,text = "Actualizar")
    }
}

@Composable
fun buttonLogOut(){
    val navigator = LocalNavigator.current
    Button(
        onClick = { navigator?.pop()},
        modifier = Modifier.fillMaxWidth(0.6f).widthIn(max = 300.dp),
        contentPadding = PaddingValues(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor =
                if (isSystemInDarkTheme()) RedColorBase.secondaryContainerDark else RedColorBase.secondaryContainerLight,
            contentColor =
                if (isSystemInDarkTheme()) RedColorBase.onSecondaryContainerDark else RedColorBase.onSecondaryContainerLight
        )
    ){
        Text(fontSize = 20.sp,text = "Salir")
    }
}