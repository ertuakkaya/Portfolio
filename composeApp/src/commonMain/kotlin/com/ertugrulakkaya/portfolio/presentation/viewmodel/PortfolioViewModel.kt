package com.ertugrulakkaya.portfolio.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ertugrulakkaya.portfolio.domain.model.PortfolioData
import com.ertugrulakkaya.portfolio.domain.repository.PortfolioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class PortfolioUiState(
    val isLoading: Boolean = true,
    val data: PortfolioData? = null,
    val error: String? = null
)

class PortfolioViewModel(
    private val repository: PortfolioRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PortfolioUiState())
    val uiState: StateFlow<PortfolioUiState> = _uiState.asStateFlow()

    init {
        loadPortfolioData()
    }

    fun loadPortfolioData() {
        viewModelScope.launch {
            _uiState.value = PortfolioUiState(isLoading = true)
            repository.getPortfolioData()
                .onSuccess { data ->
                    _uiState.value = PortfolioUiState(isLoading = false, data = data)
                }
                .onFailure { error ->
                    _uiState.value = PortfolioUiState(isLoading = false, error = error.message)
                }
        }
    }
}
