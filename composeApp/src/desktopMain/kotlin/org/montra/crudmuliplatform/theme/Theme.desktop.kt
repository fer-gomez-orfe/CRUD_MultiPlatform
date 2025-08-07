package org.montra.crudmuliplatform.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,

    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) darkColorsScheme else lightColorsScheme,
        content = content
    )
}