package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model

data class MapMainState(
    val objectInfos: List<ObjectInfo> = emptyList(),
    val selectedObjectInfoIndex: Int? = null,
)
