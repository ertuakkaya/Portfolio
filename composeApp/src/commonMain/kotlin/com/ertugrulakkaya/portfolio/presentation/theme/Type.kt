package com.ertugrulakkaya.portfolio.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Typography configuration using custom font weights
 *
 * Key Principles:
 * - Signature weight 510 (between regular 400 and medium 500)
 * - Aggressive negative letter-spacing at display sizes
 * - Three-tier weight system: 400 (reading), 510 (emphasis/UI), 590 (strong emphasis)
 */

// Font Weights 
val FontWeightReading = FontWeight(400)       // Body text, standard reading
val FontWeightEmphasis = FontWeight(510)      // Signature weight - emphasis/navigate
val FontWeightStrong = FontWeight(590)        // Strong emphasis, announcements
val FontWeightLight = FontWeight(300)         // De-emphasized contexts only

val Typography = Typography(
    // Display XL - 72px, weight 510, tight line-height, -1.584px tracking
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightEmphasis,
        fontSize = 72.sp,
        lineHeight = 72.sp,  // 1.00 tight
        letterSpacing = (-1.584).sp
    ),

    // Display Large - 64px, weight 510, tight line-height, -1.408px tracking
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightEmphasis,
        fontSize = 64.sp,
        lineHeight = 64.sp,  // 1.00 tight
        letterSpacing = (-1.408).sp
    ),

    // Display - 48px, weight 510, tight line-height, -1.056px tracking
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightEmphasis,
        fontSize = 48.sp,
        lineHeight = 48.sp,  // 1.00 tight
        letterSpacing = (-1.056).sp
    ),

    // Heading 1 - 32px, weight 400, tight line-height, -0.704px tracking
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightReading,
        fontSize = 32.sp,
        lineHeight = 36.sp,  // 1.13 tight
        letterSpacing = (-0.704).sp
    ),

    // Heading 2 - 24px, weight 400, -0.288px tracking
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightReading,
        fontSize = 24.sp,
        lineHeight = 32.sp,  // 1.33
        letterSpacing = (-0.288).sp
    ),

    // Heading 3 - 20px, weight 590, -0.24px tracking
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightStrong,
        fontSize = 20.sp,
        lineHeight = 26.sp,  // 1.33
        letterSpacing = (-0.24).sp
    ),

    // Title Large - 22px, weight 590
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightStrong,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    // Title Medium - 16px, weight 510
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightEmphasis,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),

    // Title Small - 14px, weight 510
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightEmphasis,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.165).sp
    ),

    // Body Large - 18px, weight 400, relaxed line-height, -0.165px tracking
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightReading,
        fontSize = 18.sp,
        lineHeight = 29.sp,  // 1.60 relaxed
        letterSpacing = (-0.165).sp
    ),

    // Body Medium - 16px, weight 400 (standard reading text)
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightReading,
        fontSize = 16.sp,
        lineHeight = 24.sp,  // 1.50
        letterSpacing = 0.sp
    ),

    // Body Small - 15px, weight 400
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightReading,
        fontSize = 15.sp,
        lineHeight = 24.sp,  // 1.60 relaxed
        letterSpacing = (-0.165).sp
    ),

    // Label Large - 14px, weight 510-590
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightEmphasis,
        fontSize = 14.sp,
        lineHeight = 21.sp,  // 1.50
        letterSpacing = (-0.182).sp
    ),

    // Label Medium - 13px, weight 400-510
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightReading,
        fontSize = 13.sp,
        lineHeight = 20.sp,  // 1.50
        letterSpacing = (-0.13).sp
    ),

    // Label Small - 12px, weight 400-590
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeightEmphasis,
        fontSize = 12.sp,
        lineHeight = 17.sp,  // 1.40
        letterSpacing = 0.sp
    )
)

// ============================================
// Extended Typography styles
// ============================================

// Body Emphasis - 17px, weight 590
val BodyEmphasis = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightStrong,
    fontSize = 17.sp,
    lineHeight = 27.sp,  // 1.60 relaxed
    letterSpacing = 0.sp
)

// Small Medium - 15px, weight 510
val SmallMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightEmphasis,
    fontSize = 15.sp,
    lineHeight = 24.sp,  // 1.60 relaxed
    letterSpacing = (-0.165).sp
)

// Small Semibold - 15px, weight 590
val SmallSemibold = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightStrong,
    fontSize = 15.sp,
    lineHeight = 24.sp,  // 1.60 relaxed
    letterSpacing = (-0.165).sp
)

// Small Light - 15px, weight 300
val SmallLight = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightLight,
    fontSize = 15.sp,
    lineHeight = 22.sp,  // 1.47
    letterSpacing = (-0.165).sp
)

// Caption Semibold - 13px, weight 510
val CaptionSemibold = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightEmphasis,
    fontSize = 13.sp,
    lineHeight = 20.sp,  // 1.50
    letterSpacing = (-0.13).sp
)

// Micro - 11px, weight 510
val Micro = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightEmphasis,
    fontSize = 11.sp,
    lineHeight = 15.sp,  // 1.40
    letterSpacing = 0.sp
)

// Tiny - 10px, weight 400-510
val Tiny = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightReading,
    fontSize = 10.sp,
    lineHeight = 15.sp,  // 1.50
    letterSpacing = (-0.15).sp
)

// Tiny Semibold - 10px, weight 510
val TinySemibold = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightEmphasis,
    fontSize = 10.sp,
    lineHeight = 15.sp,  // 1.50
    letterSpacing = (-0.15).sp
)

// Link Large - 16px, weight 400
val LinkLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightReading,
    fontSize = 16.sp,
    lineHeight = 24.sp,  // 1.50
    letterSpacing = 0.sp
)

// Link Medium - 15px, weight 510, spaced
val LinkMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightEmphasis,
    fontSize = 15.sp,
    lineHeight = 40.sp,  // 2.67 spaced
    letterSpacing = 0.sp
)

// Link Small - 14px, weight 510
val LinkSmall = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightEmphasis,
    fontSize = 14.sp,
    lineHeight = 21.sp,  // 1.50
    letterSpacing = 0.sp
)

// Link Caption - 13px, weight 400-510
val LinkCaption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeightReading,
    fontSize = 13.sp,
    lineHeight = 20.sp,  // 1.50
    letterSpacing = (-0.13).sp
)
