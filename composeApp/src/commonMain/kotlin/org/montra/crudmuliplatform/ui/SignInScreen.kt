package org.montra.crudmuliplatform.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class SignInScreen: Screen {
    @Composable
    override fun Content() {
        //val navigator = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(fontSize = 25.sp, text = "Ingrese sus datos para el registro")
            nameTextField()
            Spacer(modifier = Modifier.height(8.dp))
            emailTextField()
            Spacer(modifier = Modifier.height(8.dp))
            passwordTextField()
            Spacer(modifier = Modifier.height(16.dp))
            buttonReg()
            Spacer(modifier = Modifier.height(8.dp))
            buttonCancel()
        }
    }
}

 @Composable
 fun nameTextField(){
     var valueInput by remember { mutableStateOf("") }
     OutlinedTextField(
         modifier = Modifier.padding(horizontal = 16.dp),
         value = valueInput,
         onValueChange = { text ->
             valueInput = text
         },
         enabled = true,
         readOnly = false,
         label = { Text(text = "Nombre") },
         placeholder = { Text(text = "Nombre completo") },
         leadingIcon = {
             Icon(imageVector = Icons.Default.Face, contentDescription = "")
         },
         isError = true,
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
         keyboardActions = KeyboardActions(onSearch = {}),
         singleLine = true,
         maxLines = 1,
         minLines = 1,
         interactionSource = MutableInteractionSource(),
         shape = RoundedCornerShape(10.dp)
     )
 }

@Composable
fun emailTextField(){
    var valueInput by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.padding(horizontal = 16.dp),
        value = valueInput,
        onValueChange = { text ->
            valueInput = text
        },
        enabled = true,
        readOnly = false,
        label = { Text(text = "Correo") },
        placeholder = { Text(text = "ejemplo@montrasolutions.com") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "")
        },
        isError = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        keyboardActions = KeyboardActions(onSearch = {}),
        singleLine = true,
        maxLines = 1,
        minLines = 1,
        interactionSource = MutableInteractionSource(),
        shape = RoundedCornerShape(10.dp),
    )
}

@Composable
fun passwordTextField(){
    var valueInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = valueInput,
        onValueChange = { text ->
            valueInput = text
        },
        enabled = true,
        readOnly = false,
        textStyle = TextStyle(color = Color(0xFF8B0000)),
        label = { Text(text = "Contraseña") },
        placeholder = { Text(text = "******") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "")
        },
        isError = true,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        keyboardActions = KeyboardActions(onSearch = {}),
        singleLine = true,
        maxLines = 1,
        minLines = 1,
        interactionSource = MutableInteractionSource(),
        shape = RoundedCornerShape(10.dp),
    )
}

@Composable
fun buttonReg(){
    val navigator = LocalNavigator.current
    Button(
        onClick = { navigator?.pop()},
        modifier = Modifier.padding(horizontal = 50.dp),
    ){
        Text(fontSize = 20.sp,text = "Registrar usuario")
    }
}

@Composable
fun buttonCancel(){
    val navigator = LocalNavigator.current
    Button(
        onClick = { navigator?.pop()},
        modifier = Modifier.padding(horizontal = 50.dp),
    ){
        Text(fontSize = 20.sp,text = "Cancelar")
    }
}