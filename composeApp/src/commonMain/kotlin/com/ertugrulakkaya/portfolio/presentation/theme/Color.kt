package com.ertugrulakkaya.portfolio.presentation.theme

import androidx.compose.ui.graphics.Color

// ============================================
// Color Palette
// ============================================

// Background Surfaces (Dark Mode Primary)
val MarketingBlack = Color(0xFF08090A)        // Deepest background - hero/page background
val PanelDark = Color(0xFF0F1011)             // Sidebar and panel backgrounds
val Level3Surface = Color(0xFF191A1B)         // Elevated surface areas, cards, dropdowns
val SecondarySurface = Color(0xFF28282C)      // Lightest dark surface - hover states

// Text Colors
val PrimaryText = Color(0xFFF7F8F8)           // Near-white primary text
val SecondaryText = Color(0xFFD0D6E0)         // Cool silver-gray for body text
val TertiaryText = Color(0xFF8A8F98)          // Muted gray for placeholders, metadata
val QuaternaryText = Color(0xFF62666D)        // Most subdued text - timestamps, disabled

// Brand & Accent Colors
val BrandIndigo = Color(0xFF5E6AD2)           // Primary brand color - CTA backgrounds
val AccentViolet = Color(0xFF7170FF)          // Brighter variant for interactive elements
val AccentHover = Color(0xFF828FFF)           // Lighter variant for hover states
val SecurityLavender = Color(0xFF7A7FAD)      // Muted indigo for security UI

// Status Colors
val SuccessGreen = Color(0xFF27A644)          // Primary success/active status
val Emerald = Color(0xFF10B981)               // Secondary success - badges, completion

// Border & Divider Colors
val BorderPrimary = Color(0xFF23252A)         // Solid dark border for prominent separations
val BorderSecondary = Color(0xFF34343A)       // Slightly lighter solid border
val BorderTertiary = Color(0xFF3E3E44)        // Lightest solid border variant
val BorderSubtle = Color(0x0DFFFFFF)          // Ultra-subtle semi-transparent border (rgba(255,255,255,0.05))
val BorderStandard = Color(0x14FFFFFF)        // Standard semi-transparent border (rgba(255,255,255,0.08))
val LineTint = Color(0xFF141516)              // Nearly invisible line
val LineTertiary = Color(0xFF18191A)          // Slightly more visible divider

// Button Colors
val ButtonGhostBackground = Color(0x05FFFFFF) // Ghost button bg (rgba(255,255,255,0.02))
val ButtonSubtleBackground = Color(0x0AFFFFFF) // Subtle button bg (rgba(255,255,255,0.04))
val ButtonStandardBackground = Color(0x0DFFFFFF) // Standard button bg (rgba(255,255,255,0.05))

// Overlay
val OverlayPrimary = Color(0xD9000000)        // Modal/dialog backdrop (rgba(0,0,0,0.85))

// ============================================
// Light Mode Colors (when light theme is needed)
// ============================================
val LightBackground = Color(0xFFF7F8F8)       // Page background in light mode
val LightSurface = Color(0xFFF3F4F5)          // Subtle surface tinting
val LightBorder = Color(0xFFD0D6E0)           // Visible border in light contexts
val LightBorderAlt = Color(0xFFE6E6E6)        // Alternative lighter border
val PureWhite = Color(0xFFFFFFFF)             // Card surfaces, highlights

// ============================================
// Legacy Colors (for backward compatibility during migration)
// ============================================
val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

// Legacy modern minimalist colors
val Primary = BrandIndigo
val PrimaryVariant = Color(0xFFDBEAFE)
val Secondary = SecondaryText
val Background = MarketingBlack
val Surface = PanelDark
val SurfaceVariant = Level3Surface
val OnPrimary = PrimaryText
val OnSecondary = PrimaryText
val OnBackground = PrimaryText
val OnSurface = PrimaryText
val OnSurfaceVariant = SecondaryText

// Dark theme aliases (same as main colors since dark is primary)
val DarkPrimary = BrandIndigo
val DarkPrimaryVariant = Color(0xFF1E1F23)
val DarkSecondary = SecondaryText
val DarkBackground = MarketingBlack
val DarkSurface = PanelDark
val DarkSurfaceVariant = Level3Surface
val DarkOnPrimary = PrimaryText
val DarkOnSecondary = PrimaryText
val DarkOnBackground = PrimaryText
val DarkOnSurface = PrimaryText
val DarkOnSurfaceVariant = SecondaryText
