package com.awebber.kmmproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
