package com.ertugrulakkaya.portfolio.di

import com.ertugrulakkaya.portfolio.data.repository.PortfolioRepositoryImpl
import com.ertugrulakkaya.portfolio.data.source.PortfolioJsonSource
import com.ertugrulakkaya.portfolio.domain.repository.PortfolioRepository
import com.ertugrulakkaya.portfolio.presentation.viewmodel.PortfolioViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<PortfolioRepository> { PortfolioRepositoryImpl(get()) }
    single { PortfolioJsonSource() }
    viewModel { PortfolioViewModel(get()) }
}
