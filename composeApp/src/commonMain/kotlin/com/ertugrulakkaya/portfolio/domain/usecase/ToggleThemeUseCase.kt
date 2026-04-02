package com.ertugrulakkaya.portfolio.domain.usecase

import com.ertugrulakkaya.portfolio.domain.repository.ThemeRepository

class ToggleThemeUseCase(
    private val repository: ThemeRepository
) {
    operator fun invoke() = repository.toggleTheme()
}
