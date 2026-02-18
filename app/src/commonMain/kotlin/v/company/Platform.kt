package v.company

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform