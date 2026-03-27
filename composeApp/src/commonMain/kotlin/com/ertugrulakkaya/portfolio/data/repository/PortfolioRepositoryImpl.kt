package com.ertugrulakkaya.portfolio.data.repository

import com.ertugrulakkaya.portfolio.data.source.PortfolioJsonSource
import com.ertugrulakkaya.portfolio.domain.model.PortfolioData
import com.ertugrulakkaya.portfolio.domain.repository.PortfolioRepository

class PortfolioRepositoryImpl(
    private val jsonSource: PortfolioJsonSource
) : PortfolioRepository {

    override suspend fun getPortfolioData(): Result<PortfolioData> {
        return try {
            val data = jsonSource.loadPortfolioData()
            Result.success(data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
