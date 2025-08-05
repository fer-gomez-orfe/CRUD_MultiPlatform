package org.montra.crudmuliplatform.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
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
import crud_multiplatform.composeapp.generated.resources.Res
import crud_multiplatform.composeapp.generated.resources.logo_blanco_rojo_montra
import org.jetbrains.compose.resources.painterResource


class MainScreen:Screen {
    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top){
            cargaLogo()
            Spacer(modifier = Modifier.height(30.dp))
            emailTextField()
            Spacer(modifier = Modifier.height(8.dp))
            passwordTextField()
            Spacer(modifier = Modifier.height(30.dp))
            buttonLogin()
            Spacer(modifier = Modifier.height(8.dp))
            buttonSignIn()

        }
    }

    @Composable
    fun emailTextField(){
        var valueInput by remember { mutableStateOf("") }
        OutlinedTextField(
            //modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            value = valueInput,
            onValueChange = { text ->
                valueInput = text
            },
            enabled = true,
            readOnly = false,
            textStyle = TextStyle(color = Color(0xFF8B0000)),
            label = { Text(text = "Correo")},
            placeholder = { Text(text = "ejemplo@montrasolutions.com") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "")
            },
            isError = true,
            //visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            keyboardActions = KeyboardActions(onSearch = {}),
            singleLine = true,
            maxLines = 1,
            minLines = 1,
            interactionSource = MutableInteractionSource(),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.DarkGray,
                cursorColor = Color.Yellow )
        )
    }

    @Composable
    fun passwordTextField(){
        var valueInput by remember { mutableStateOf("") }
        OutlinedTextField(
            //modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            value = valueInput,
            onValueChange = { text ->
                valueInput = text
            },
            enabled = true,
            readOnly = false,
            textStyle = TextStyle(color = Color(0xFF8B0000)),
            label = { Text(text = "Contraseña")},
            placeholder = { Text(text = "********") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "")
            },
            isError = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            keyboardActions = KeyboardActions(onSearch = {}),
            singleLine = true,
            maxLines = 1,
            minLines = 1,
            interactionSource = MutableInteractionSource(),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.DarkGray,
                cursorColor = Color.Yellow )
        )
    }

    @Composable
    fun buttonLogin(){
        val navigator = LocalNavigator.current
        Button(
            onClick = { navigator?.push(InterScreen())},
            //modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF8B0000), contentColor = Color.White)
        ){
            Text(fontSize = 20.sp,text = "Ingresar")
        }
    }

    @Composable
    fun buttonSignIn(){
        val navigator = LocalNavigator.current
        Button(
            onClick = { navigator?.push(SignInScreen())},
            //modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF696969), contentColor = Color.White)
        ){
            Text(fontSize = 20.sp,text = "Registrarse")
        }
    }

    @Composable
    fun cargaLogo(){
        Box(modifier = Modifier.fillMaxWidth().height(200.dp).background(Color.Black), contentAlignment = Alignment.Center) {
            Image(painterResource(Res.drawable.logo_blanco_rojo_montra),
                null,
                modifier = Modifier.size(200.dp))
        }
    }

}

