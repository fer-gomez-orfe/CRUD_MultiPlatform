package org.montra.crudmuliplatform.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.backgroundDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.backgroundLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.errorLD
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onBackDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onBackLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onError
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onPrimaryContainerDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onPrimaryContainerLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onPrimaryDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onPrimaryLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onSecondaryContainerDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onSecondaryContainerLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onSecondaryDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onSecondaryLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onSurDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.onSurLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.primaryContainerDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.primaryContainerLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.primaryDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.primaryLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.secondaryContainerDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.secondaryContainerLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.secondaryDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.secondaryLight
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.surfaceDark
import org.montra.crudmuliplatform.theme.color_palettes.RedColorBase.surfaceLight

val lightColorsScheme = lightColorScheme(
        primary = primaryLight,
        onPrimary = onPrimaryLight,
        secondary = onSecondaryLight,
        primaryContainer = primaryContainerLight,
        onPrimaryContainer = onPrimaryContainerLight,
        onSecondary = secondaryLight,
        secondaryContainer = onSecondaryContainerLight,
        onSecondaryContainer = secondaryContainerLight,
        background = backgroundLight,
        onBackground = onBackLight,
        surface = surfaceLight,
        onSurface = onSurLight,
        error = errorLD,
        onError = onError,

    )

val darkColorsScheme = darkColorScheme(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        primaryContainer = primaryContainerDark,
        onPrimaryContainer = onPrimaryContainerDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        secondaryContainer = secondaryContainerDark,
        onSecondaryContainer = onSecondaryContainerDark,
        background = backgroundDark,
        onBackground = onBackDark,
        surface = surfaceDark,
        onSurface = onSurDark,
        error = errorLD,
        onError = onError
    )

@Composable
expect fun AppTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
)