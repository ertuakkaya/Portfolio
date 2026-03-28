package com.ertugrulakkaya.portfolio

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ertugrulakkaya.portfolio.di.appModule
import com.ertugrulakkaya.portfolio.presentation.screen.PortfolioScreen
import com.ertugrulakkaya.portfolio.presentation.theme.PortfolioTheme
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        PortfolioTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.surface
            ) {
                PortfolioScreen()
            }
        }
    }
}
