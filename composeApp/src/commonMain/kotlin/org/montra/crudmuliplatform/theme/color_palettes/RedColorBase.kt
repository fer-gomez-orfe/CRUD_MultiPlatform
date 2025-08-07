package org.montra.crudmuliplatform.theme.color_palettes

import androidx.compose.ui.graphics.Color
import org.montra.crudmuliplatform.theme.MaterialThemeColorsPalette

object RedColorBase : MaterialThemeColorsPalette {
    override val primaryLight: Color = Color(0xFFC51111)
    override val onPrimaryLight: Color = Color.White
    override val primaryContainerLight: Color = Color(0xFFFF6767)
    override val onPrimaryContainerLight: Color = Color(0xFFA21212)

    override val secondaryLight: Color = Color(0xFF197278)
    override val onSecondaryLight: Color = Color.White
    override val secondaryContainerLight: Color = Color(0xFF69DFDE)
    override val onSecondaryContainerLight: Color = Color(0xFF175358)

    override val backgroundLight: Color = Color.White
    override val surfaceLight: Color = Color.White
    override val onBackLight: Color = Color.Black
    override val onSurLight: Color = Color.Black

    override val errorLD: Color = Color(0xFF490606)
    override val onError: Color = Color.White

    override val primaryDark: Color = Color(0xFFFF9F9F)
    override val onPrimaryDark: Color = Color.Black
    override val primaryContainerDark: Color = Color(0xFFA21212)
    override val onPrimaryContainerDark: Color = Color(0xFFFF6767)

    override val secondaryDark: Color = Color(0xFFF6B329)
    override val onSecondaryDark: Color = Color.Black
    override val secondaryContainerDark: Color = Color(0xFF17858A)
    override val onSecondaryContainerDark: Color = Color(0xFFA0EFEB)

    override val backgroundDark: Color = Color.Black
    override val surfaceDark: Color = Color.Black
    override val onBackDark: Color = Color.White
    override val onSurDark: Color = Color.White

}