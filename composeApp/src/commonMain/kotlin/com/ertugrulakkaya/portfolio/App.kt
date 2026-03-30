package com.ertugrulakkaya.portfolio

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ertugrulakkaya.portfolio.di.appModule
import com.ertugrulakkaya.portfolio.presentation.screen.PortfolioScreen
import com.ertugrulakkaya.portfolio.presentation.theme.PortfolioTheme
import com.ertugrulakkaya.portfolio.presentation.viewmodel.ThemeViewModel
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject

@Composable
fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        val themeViewModel: ThemeViewModel = koinInject()
        val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

        PortfolioTheme(darkTheme = isDarkTheme) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.surface
            ) {
                PortfolioScreen()
            }
        }
    }
}
