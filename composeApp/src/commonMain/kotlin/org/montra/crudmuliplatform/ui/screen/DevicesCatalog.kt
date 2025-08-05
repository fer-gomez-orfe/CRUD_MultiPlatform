package org.montra.crudmuliplatform.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class DevicesCatalog : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(Modifier.fillMaxWidth(), horizontalAlignment =  Alignment.CenterHorizontally){
            DevicesScreen()
        }

    }

    private @Composable
    fun DevicesScreen() {
        TODO("Not yet implemented")
    }
}