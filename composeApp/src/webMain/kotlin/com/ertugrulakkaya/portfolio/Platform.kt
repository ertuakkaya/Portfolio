package com.ertugrulakkaya.portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform