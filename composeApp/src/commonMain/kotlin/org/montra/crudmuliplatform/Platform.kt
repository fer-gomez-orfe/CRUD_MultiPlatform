package org.montra.crudmuliplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform