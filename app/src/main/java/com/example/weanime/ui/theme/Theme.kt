package com.example.weanime.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFFFE89A2),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFD8E0),
    onPrimaryContainer = Color(0xFF480018),

    secondary = Color(0xFFFFB3C0),
    onSecondary = Color(0xFF3E0015),
    secondaryContainer = Color(0xFFFFDCE4),
    onSecondaryContainer = Color(0xFF2E0010),

    tertiary = Color(0xFFFFCCB9),
    onTertiary = Color(0xFF43200A),

    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF1B1B1B),

    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1B1B1B),

    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF)
)

@Composable
fun WeAnimeTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = WeAnimeTypography,
        content = content
    )
}
