package com.ertugrulakkaya.portfolio.domain.usecase

import com.ertugrulakkaya.portfolio.domain.model.PortfolioData
import com.ertugrulakkaya.portfolio.domain.repository.PortfolioRepository

class GetPortfolioDataUseCase(
    private val repository: PortfolioRepository
) {
    suspend operator fun invoke(): Result<PortfolioData> = repository.getPortfolioData()
}
