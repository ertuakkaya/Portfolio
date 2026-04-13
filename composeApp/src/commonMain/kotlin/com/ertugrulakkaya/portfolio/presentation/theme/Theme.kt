package com.ertugrulakkaya.portfolio.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



// Dark Color Scheme (Primary )
private val DarkColorScheme = darkColorScheme(
    // Primary colors - Brand Indigo
    primary = BrandIndigo,
    onPrimary = PrimaryText,
    primaryContainer = Level3Surface,
    onPrimaryContainer = PrimaryText,

    // Secondary colors - Accent Violet
    secondary = AccentViolet,
    onSecondary = PrimaryText,
    secondaryContainer = Level3Surface,
    onSecondaryContainer = PrimaryText,

    // Background colors
    background = MarketingBlack,
    onBackground = PrimaryText,

    // Surface colors - using elevation-based luminance
    surface = PanelDark,                    // Level 0 - base surface
    onSurface = PrimaryText,
    surfaceVariant = Level3Surface,         // Level 1 - elevated
    onSurfaceVariant = SecondaryText,
    surfaceTint = BrandIndigo,

    // Error colors
    error = SuccessGreen,                   // Using green for success, but mapping to error for Material compatibility
    onError = PrimaryText,
    errorContainer = Level3Surface,
    onErrorContainer = SuccessGreen,

    // Outline colors - semi-transparent borders
    outline = BorderStandard,
    outlineVariant = BorderSubtle,

    // Inverse colors (for contrast elements)
    inverseSurface = LightSurface,
    inverseOnSurface = Color(0xFF0F172A),
    inversePrimary = AccentViolet,

    // Scrim for overlays
    scrim = OverlayPrimary
)

// Light Color Scheme (Alternative)
private val LightColorScheme = lightColorScheme(
    // Primary colors
    primary = BrandIndigo,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE0E7FF),
    onPrimaryContainer = BrandIndigo,

    // Secondary colors
    secondary = AccentViolet,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFEEF2FF),
    onSecondaryContainer = AccentViolet,

    // Background colors
    background = LightBackground,
    onBackground = Color(0xFF0F172A),

    // Surface colors
    surface = PureWhite,
    onSurface = Color(0xFF0F172A),
    surfaceVariant = LightSurface,
    onSurfaceVariant = Color(0xFF475569),
    surfaceTint = BrandIndigo,

    // Error colors
    error = SuccessGreen,
    onError = Color.White,
    errorContainer = Color(0xFFE0F2E9),
    onErrorContainer = SuccessGreen,

    // Outline colors
    outline = LightBorder,
    outlineVariant = LightBorderAlt,

    // Inverse colors
    inverseSurface = MarketingBlack,
    inverseOnSurface = PrimaryText,
    inversePrimary = BrandIndigo,

    // Scrim
    scrim = OverlayPrimary
)

@Composable
fun PortfolioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun isDarkTheme(): Boolean {
    return MaterialTheme.colorScheme.background == MarketingBlack
}
