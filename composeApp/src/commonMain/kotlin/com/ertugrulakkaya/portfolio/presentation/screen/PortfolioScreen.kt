package com.ertugrulakkaya.portfolio.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.ertugrulakkaya.portfolio.domain.model.PortfolioData
import com.ertugrulakkaya.portfolio.presentation.components.ErrorState
import com.ertugrulakkaya.portfolio.presentation.components.LoadingState
import com.ertugrulakkaya.portfolio.presentation.components.ProfileHeader
import com.ertugrulakkaya.portfolio.presentation.components.ProjectsSection
import com.ertugrulakkaya.portfolio.presentation.components.SkillsSection
import com.ertugrulakkaya.portfolio.presentation.components.EducationSection
import com.ertugrulakkaya.portfolio.presentation.components.ExperienceSection
import com.ertugrulakkaya.portfolio.presentation.viewmodel.PortfolioViewModel

import org.koin.compose.koinInject

@Composable
fun PortfolioScreen(
    viewModel: PortfolioViewModel = koinInject()
) {
    val uiState by viewModel.uiState.collectAsState()
    val isLoading = uiState.isLoading
    val error = uiState.error
    val data = uiState.data

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)

    ) {
        if (data != null) {
            PortfolioContent(data = data)
        }

        if (isLoading) {
            if (data == null) {
                LoadingState()
            } else {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                )
            }
        }

        if (error != null) {
            if (data == null) {
                ErrorState(error = error)
            } else {
                Snackbar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp),
                    action = {
                        TextButton(onClick = { viewModel.loadPortfolioData() }) {
                            Text("Retry")
                        }
                    }
                ) {
                    Text(error)
                }
            }
        }
    }
}

@Composable
private fun PortfolioContent(
    data: PortfolioData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        ProfileHeader(profile = data.profile)

        HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

        ProjectsSection(projects = data.projects)

        HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

        ExperienceSection(experiences = data.experiences)

        HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

        EducationSection(education = data.education)

        HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

        SkillsSection(skills = data.skills)

        Spacer(modifier = Modifier.height(32.dp))
    }
}
