package org.montra.crudmuliplatform.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.montra.crudmuliplatform.ui.screen.SparePartsCatalog
import org.montra.crudmuliplatform.ui.screen.UpdateSpareParts

class InterScreen: Screen {
    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            buttonViewAll()
            Spacer(modifier = Modifier.height(10.dp))
            buttonUpdate()
            Spacer(modifier = Modifier.height(10.dp))
            buttonLogOut()
        }
    }
}

@Composable
fun buttonViewAll(){
    val navigator = LocalNavigator.current
    Button(
        onClick = { navigator?.push(SparePartsCatalog())},
        modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF8B0000), contentColor = Color.White),
        contentPadding = PaddingValues(10.dp)
    ){
        Text(fontSize = 20.sp,text = "Ver Catalogo")
    }
}

@Composable
fun buttonUpdate(){
    val navigator = LocalNavigator.current
    Button(
        onClick = { navigator?.push(UpdateSpareParts())},
        modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF8B0000), contentColor = Color.White),
        contentPadding = PaddingValues(10.dp)
    ){
        Text(fontSize = 20.sp,text = "Actualizar")
    }
}

@Composable
fun buttonLogOut(){
    val navigator = LocalNavigator.current
    Button(
        onClick = { navigator?.pop()},
        modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF696969), contentColor = Color.White),
        contentPadding = PaddingValues(10.dp)
    ){
        Text(fontSize = 20.sp,text = "Salir")
    }
}