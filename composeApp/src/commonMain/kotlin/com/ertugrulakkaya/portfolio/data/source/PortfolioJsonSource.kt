package com.ertugrulakkaya.portfolio.data.source

import com.ertugrulakkaya.portfolio.domain.model.PortfolioData
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.readBytes

class PortfolioJsonSource {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @OptIn(ExperimentalResourceApi::class)
    suspend fun loadPortfolioData(): PortfolioData = withContext(kotlinx.coroutines.Dispatchers.Default) {
        val jsonString = readBytes("files/portfolio.json").decodeToString()
        json.decodeFromString<PortfolioData>(jsonString)
    }
}
