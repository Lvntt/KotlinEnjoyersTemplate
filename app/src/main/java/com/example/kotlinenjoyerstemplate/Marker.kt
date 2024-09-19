package com.example.kotlinenjoyerstemplate

import kotlinx.coroutines.flow.MutableStateFlow

object Marker {
    val markerFlow = MutableStateFlow<Boolean?>(null)
}