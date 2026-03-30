package com.ertugrulakkaya.portfolio.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ertugrulakkaya.portfolio.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeViewModel(
    private val themeRepository: ThemeRepository
) : ViewModel() {

    val isDarkTheme: StateFlow<Boolean> = themeRepository.isDarkTheme

    fun toggleTheme() {
        themeRepository.toggleTheme()
    }
}
