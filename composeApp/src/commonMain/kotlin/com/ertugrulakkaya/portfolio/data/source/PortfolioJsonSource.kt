package com.ertugrulakkaya.portfolio.data.source

import com.ertugrulakkaya.portfolio.domain.model.PortfolioData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import portfolio.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

class PortfolioJsonSource {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @OptIn(ExperimentalResourceApi::class)
    suspend fun loadPortfolioData(): PortfolioData = withContext(Dispatchers.Default) {
        val jsonString = Res.readBytes("files/portfolio.json").decodeToString()
        json.decodeFromString<PortfolioData>(jsonString)
    }
}
