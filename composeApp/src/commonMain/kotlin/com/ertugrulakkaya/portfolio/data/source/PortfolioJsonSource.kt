package com.ertugrulakkaya.portfolio.data.source

import com.ertugrulakkaya.portfolio.domain.model.PortfolioData
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class PortfolioJsonSource {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    suspend fun loadPortfolioData(): PortfolioData = withContext(kotlinx.coroutines.Dispatchers.Default) {
        val jsonString = getJsonString()
        json.decodeFromString<PortfolioData>(jsonString)
    }

    private fun getJsonString(): String {
        return """
        {
          "profile": {
            "name": "Ertuğrul AKKAYA",
            "title": "Mobile Developer | Kotlin, Jetpack Compose & KMP Expert",
            "bio": "Results-driven Mobile Developer specializing in Kotlin, Jetpack Compose, and Kotlin Multiplatform (KMP) for scalable Android and iOS applications. Backed by solid backend capabilities in ASP.NET Core and PostgreSQL to deliver seamless end-to-end integrations. Passionate about clean architecture, agile teamwork, and building maintainable products from scratch.",
            "email": "ertuakkaya@gmail.com",
            "phone": "+90 554 742 45 93",
            "location": "Ankara, Turkey",
            "avatarUrl": "https://media.licdn.com/dms/image/v2/D4D03AQGfkJ8P7zaDPA/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1706806864795?e=1776297600&v=beta&t=XI43lUJe-Bn5u_oQfeNCEdsYhQuVs1cw4aFTCicjFe4",
            "socialLinks": [
              {
                "type": "GITHUB",
                "url": "https://github.com/ertuakkaya",
                "iconName": "GitHub"
              },
              {
                "type": "LINKEDIN",
                "url": "https://linkedin.com/in/ertuakkaya",
                "iconName": "LinkedIn"
              }
            ]
          },
          "experiences": [
            {
              "id": "1",
              "company": "Termtech, Düzce Teknopark",
              "position": "Mobile Developer",
              "startDate": "2024-08",
              "endDate": "2026-01",
              "isCurrent": true,
              "description": "Field-Task App: Engineered an Android/iOS KMP app with Jetpack Compose, featuring real-time geolocation, QR-triggered execution, and rich-media capture for on-site reporting. IoT Integration: Developed an MQTT-based telemetry tracking solution with robust device provisioning and direct mobile Wi-Fi configuration. Architecture: Architected scalable codebases using Clean Architecture, MVVM, and Compose Multiplatform to maximize UI code-sharing and native performance. Full-Stack Support: Integrated ASP.NET Core & PostgreSQL APIs, optimizing payloads and implementing push notifications for instant updates.",
              "location": "Düzce, Turkey"
            },
            {
              "id": "2",
              "company": "Termtech, Düzce Teknopark",
              "position": "Mobile Application Developer Intern",
              "startDate": "2024-07",
              "endDate": "2024-08",
              "isCurrent": false,
              "description": "Supported native Android development, RESTful API integrations, and actively participated in agile debugging phases.",
              "location": "Düzce, Turkey"
            }
          ],
          "education": [
            {
              "id": "1",
              "school": "Düzce University",
              "degree": "Bachelor of Science",
              "field": "Computer Engineering",
              "startDate": "2020-09",
              "endDate": "2024-06",
              "isCurrent": false,
              "gpa": "3.47",
              "description": "Computer Engineering undergraduate program."
            },
            {
              "id": "2",
              "school": "Sinop Science High School",
              "degree": "High School",
              "field": "Science",
              "startDate": "2014-09",
              "endDate": "2018-06",
              "isCurrent": false,
              "description": "Science-focused high school education."
            }
          ],
          "projects": [
            {
              "id": "1",
              "name": "FoodAppKMP",
              "description": "Architected a cross-platform food ordering application, achieving high UI/UX consistency across both Android and iOS environments through a highly optimized shared codebase.",
              "technologies": ["Kotlin Multiplatform", "Compose Multiplatform"],
              "demoUrl": null,
              "sourceUrl": "https://github.com/ertuakkaya/FoodAppKMP",
              "isFeatured": true,
              "isKmpProject": true
            },
            {
              "id": "2",
              "name": "ContactApp",
              "description": "Developed a fully modular Android application following Clean Architecture and an event-driven state management approach (unidirectional data flow). Implemented use-case–driven domain logic, single source of truth state handling with Kotlin Flow, and dependency injection via Hilt to ensure testability and scalability.",
              "technologies": ["Kotlin", "Jetpack Compose", "Clean Architecture", "Hilt"],
              "demoUrl": null,
              "sourceUrl": "https://github.com/ertuakkaya/ContactApp",
              "isFeatured": true,
              "isKmpProject": false
            },
            {
              "id": "3",
              "name": "bsStoreApp (Backend REST API)",
              "description": "Built a robust and scalable RESTful API for an e-commerce platform, handling complex operations including pagination and API versioning.",
              "technologies": ["ASP.NET Core", "JWT Auth", "Caching", "EF Core", "PostgreSQL"],
              "demoUrl": null,
              "sourceUrl": "https://github.com/ertuakkaya/bsStoreApp",
              "isFeatured": false,
              "isKmpProject": false
            }
          ],
          "skills": [
            { "id": "1", "name": "Kotlin", "category": "LANGUAGE", "proficiencyLevel": 95 },
            { "id": "2", "name": "ASP.NET Core", "category": "LANGUAGE", "proficiencyLevel": 80 },
            { "id": "3", "name": "Jetpack Compose", "category": "FRAMEWORK", "proficiencyLevel": 95 },
            { "id": "4", "name": "Kotlin Multiplatform (KMP)", "category": "FRAMEWORK", "proficiencyLevel": 90 },
            { "id": "5", "name": "Compose Multiplatform", "category": "FRAMEWORK", "proficiencyLevel": 90 },
            { "id": "6", "name": "Android SDK", "category": "FRAMEWORK", "proficiencyLevel": 95 },
            { "id": "7", "name": "Clean Architecture", "category": "ARCHITECTURE", "proficiencyLevel": 90 },
            { "id": "8", "name": "MVVM", "category": "ARCHITECTURE", "proficiencyLevel": 95 },
            { "id": "9", "name": "Room", "category": "DATABASE", "proficiencyLevel": 90 },
            { "id": "10", "name": "PostgreSQL", "category": "DATABASE", "proficiencyLevel": 80 },
            { "id": "11", "name": "EF Core", "category": "DATABASE", "proficiencyLevel": 80 },
            { "id": "12", "name": "Git", "category": "TOOL", "proficiencyLevel": 90 },
            { "id": "13", "name": "Firebase", "category": "TOOL", "proficiencyLevel": 75 },
            { "id": "14", "name": "MQTT", "category": "TOOL", "proficiencyLevel": 80 },
            { "id": "15", "name": "Hilt", "category": "TOOL", "proficiencyLevel": 85 },
            { "id": "16", "name": "Coroutines", "category": "TOOL", "proficiencyLevel": 90 }
          ]
        }
        """.trimIndent()
    }
}
