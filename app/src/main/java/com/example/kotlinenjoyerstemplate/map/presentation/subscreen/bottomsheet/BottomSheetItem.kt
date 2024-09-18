package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.bottomsheet

import androidx.annotation.DrawableRes

data class BottomSheetItem(
    @DrawableRes val iconResId: Int,
    val title: String,
    val onClick: () -> Unit,
)
