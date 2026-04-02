package com.ertugrulakkaya.portfolio.domain.usecase

import com.ertugrulakkaya.portfolio.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.StateFlow

class GetThemeStateUseCase(
    private val repository: ThemeRepository
) {
    operator fun invoke(): StateFlow<Boolean> = repository.isDarkTheme
}
