package com.ertugrulakkaya.portfolio.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ertugrulakkaya.portfolio.domain.usecase.GetThemeStateUseCase
import com.ertugrulakkaya.portfolio.domain.usecase.ToggleThemeUseCase
import kotlinx.coroutines.flow.StateFlow

class ThemeViewModel(
    getThemeStateUseCase: GetThemeStateUseCase,
    private val toggleThemeUseCase: ToggleThemeUseCase
) : ViewModel() {

    val isDarkTheme: StateFlow<Boolean> = getThemeStateUseCase()

    fun toggleTheme() {
        toggleThemeUseCase()
    }
}
