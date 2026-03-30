package com.ertugrulakkaya.portfolio.di

import com.ertugrulakkaya.portfolio.data.repository.PortfolioRepositoryImpl
import com.ertugrulakkaya.portfolio.data.repository.ThemeRepositoryImpl
import com.ertugrulakkaya.portfolio.data.source.PortfolioJsonSource
import com.ertugrulakkaya.portfolio.domain.repository.PortfolioRepository
import com.ertugrulakkaya.portfolio.domain.repository.ThemeRepository
import com.ertugrulakkaya.portfolio.presentation.viewmodel.PortfolioViewModel
import com.ertugrulakkaya.portfolio.presentation.viewmodel.ThemeViewModel
import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Settings() }
    single<ThemeRepository> { ThemeRepositoryImpl(get()) }
    single<PortfolioRepository> { PortfolioRepositoryImpl(get()) }
    single { PortfolioJsonSource() }
    viewModel { ThemeViewModel(get()) }
    viewModel { PortfolioViewModel(get()) }
}
