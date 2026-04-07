package com.ertugrulakkaya.portfolio.data.repository

import com.russhwolf.settings.Settings
import com.ertugrulakkaya.portfolio.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ThemeRepositoryImpl(
    private val settings: Settings
) : ThemeRepository {

    private val _isDarkTheme = MutableStateFlow(settings.getBoolean(IS_DARK_THEME_KEY, true))
    override val isDarkTheme: StateFlow<Boolean> = _isDarkTheme.asStateFlow()

    override fun toggleTheme() {
        val newValue = !_isDarkTheme.value
        settings.putBoolean(IS_DARK_THEME_KEY, newValue)
        _isDarkTheme.value = newValue
    }

    override fun setDarkTheme(isDark: Boolean) {
        settings.putBoolean(IS_DARK_THEME_KEY, isDark)
        _isDarkTheme.value = isDark
    }

    companion object {
        private const val IS_DARK_THEME_KEY = "is_dark_theme"
    }
}
