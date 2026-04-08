# Portfolio

A modern Kotlin Multiplatform portfolio application showcasing mobile development expertise.

## Overview

This project demonstrates cross-platform mobile development using Kotlin, Jetpack Compose, and Compose Multiplatform. It targets Web (Wasm/JS) and Android platforms from a single codebase.

## Tech Stack

| Category | Technology |
|----------|------------|
| **Language** | Kotlin 2.3.10 |
| **UI Framework** | Compose Multiplatform 1.10.0 |
| **Design System** | Material 3 |
| **Architecture** | Clean Architecture + MVVM |
| **Dependency Injection** | Koin 4.0.0 |
| **Image Loading** | Coil3 3.4.0 |
| **State Management** | Kotlin Flow + ViewModel |
| **Data Storage** | Multiplatform Settings |
| **Serialization** | Kotlinx Serialization |

## Project Structure

```
composeApp/src/
├── commonMain/kotlin/
│   └── com/ertugrulakkaya/portfolio/
│       ├── di/              # Dependency injection
│       ├── domain/          # Business logic layer
│       │   ├── model/       # Data models
│       │   ├── repository/  # Repository interfaces
│       │   └── usecase/     # Use cases
│       ├── data/            # Data layer
│       │   ├── repository/  # Repository implementations
│       │   └── source/      # Data sources
│       └── presentation/    # UI layer
│           ├── screen/      # Screens
│           ├── components/  # UI components
│           ├── viewmodel/   # ViewModels
│           └── theme/       # Theme configuration
├── webMain/                 # Web platform
└── androidMain/            # Android platform
```

## Features

- **Dark/Light Theme** - System preference detection with manual toggle (persisted)
- **Responsive Design** - Adaptive layouts for different screen sizes
- **Smooth Animations** - Staggered fade-in effects on load
- **Content-driven** - Portfolio data loaded from JSON

## Build & Run

### Web (Wasm)
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### Web (JS)
```bash
./gradlew :composeApp:jsBrowserDevelopmentRun
```

### Android
Build using Android Studio or:
```bash
./gradlew :composeApp:compileDebugKotlinAndroid
```

## Architecture Highlights

- **Clean Architecture** with three distinct layers
- **Repository Pattern** for data abstraction
- **Use Cases** for business logic encapsulation
- **ViewModels** with Kotlin Flow for reactive state management
- **Koin** for lightweight dependency injection

---

Built with Kotlin Multiplatform