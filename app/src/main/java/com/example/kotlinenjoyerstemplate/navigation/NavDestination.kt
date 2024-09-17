package com.example.kotlinenjoyerstemplate.navigation

interface NavDestination {

    val baseRoute: String

    val arguments: List<String>
        get() = emptyList()

    fun getDestination() = buildString {
        append(baseRoute)
        arguments.forEach { arg ->
            append("/{$arg}")
        }
    }

    fun getNavigationRoute(vararg args: Any?) = buildString {
        append(baseRoute)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}