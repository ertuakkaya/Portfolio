package com.ertugrulakkaya.portfolio.domain.repository

import kotlinx.coroutines.flow.StateFlow

interface ThemeRepository {
    val isDarkTheme: StateFlow<Boolean>
    fun toggleTheme()
    fun setDarkTheme(isDark: Boolean)
}
