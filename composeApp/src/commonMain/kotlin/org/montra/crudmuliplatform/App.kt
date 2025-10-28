package org.montra.crudmuliplatform

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.montra.crudmuliplatform.theme.AppTheme
import org.montra.crudmuliplatform.ui.LogInScreen

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
) {
    AppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        Navigator(screen = LogInScreen()){ navigator: Navigator ->
            SlideTransition(navigator)
        }
    }

}
