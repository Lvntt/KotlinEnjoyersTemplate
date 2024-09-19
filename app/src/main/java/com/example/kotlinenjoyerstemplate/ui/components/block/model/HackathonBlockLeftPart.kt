package com.example.kotlinenjoyerstemplate.ui.components.block.model

import com.example.kotlinenjoyerstemplate.ui.common.ImageSource

sealed interface HackathonBlockLeftPart {

    data class Icon(
        val source: ImageSource,
        val sizeDp: Int,
        val onClick: (() -> Unit)? = null,
    ) : HackathonBlockLeftPart

    data class Image(
        val source: ImageSource,
        val widthDp: Int,
        val heightDp: Int,
    ) : HackathonBlockLeftPart
}
