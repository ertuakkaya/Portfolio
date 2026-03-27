package com.ertugrulakkaya.portfolio.domain.repository

import com.ertugrulakkaya.portfolio.domain.model.PortfolioData

interface PortfolioRepository {
    suspend fun getPortfolioData(): Result<PortfolioData>
}
