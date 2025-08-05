package org.montra.crudmuliplatform

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.montra.crudmuliplatform.di.dataModule
import org.montra.crudmuliplatform.di.initKoin
import org.montra.crudmuliplatform.di.viewModelsModule


fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Spare_Parts_Koin",
        ) {
            App()
        }
    }
}