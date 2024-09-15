package com.example.kotlinenjoyerstemplate.ui.components.header_block.model

import com.example.kotlinenjoyerstemplate.ui.common.ImageSource

sealed interface HackathonHeaderBlockRightPart {

    data class Icon(
        val source: ImageSource,
        val sizeDp: Int,
        val onClick: (() -> Unit)? = null,
    ) : HackathonHeaderBlockRightPart
}
