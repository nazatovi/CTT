package com.ctt.adminispmobile.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(

    primary = Primary,
    onPrimary = TextPrimary,

    secondary = Info,
    tertiary = Success,

    background = Background,
    onBackground = TextPrimary,

    surface = Surface,
    onSurface = TextPrimary,

    error = Error,
    outline = Border

)

private val LightColorScheme = lightColorScheme(

    primary = Primary,
    onPrimary = TextPrimary,

    secondary = Info,
    tertiary = Success,

    background = Color.White,
    onBackground = Color.Black,

    surface = Color(0xFFF4F4F4),
    onSurface = Color.Black,

    error = Error,
    outline = Border

)

@Composable
fun AdminISPMobileTheme(

    darkTheme: Boolean = true,

    content: @Composable () -> Unit

) {

    MaterialTheme(

        colorScheme =
            if (darkTheme)
                DarkColorScheme
            else
                LightColorScheme,

        typography = Typography,

        content = content

    )

}