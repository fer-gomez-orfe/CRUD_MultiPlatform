package org.montra.crudmuliplatform

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.montra.crudmuliplatform.ui.MainScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(screen = MainScreen()){navigator: Navigator ->
            SlideTransition(navigator)
        }
    }
}
