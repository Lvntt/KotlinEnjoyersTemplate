package com.example.kotlinenjoyerstemplate.ui.components.block.model

import com.example.kotlinenjoyerstemplate.ui.common.ImageSource

sealed interface HackathonBlockRightPart {

    data class Icon(
        val source: ImageSource,
        val sizeDp: Int,
        val onClick: (() -> Unit)? = null
    ) : HackathonBlockRightPart
}