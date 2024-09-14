package com.example.kotlinenjoyerstemplate.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

sealed interface ImageSource {

    val contentDescription: String?
    val tint: Color?
    val shape: Shape?
    val backgroundColor: Color?

    data class FromResource(
        val resId: Int,
        override val contentDescription: String?,
        override val tint: Color? = null,
        override val shape: Shape? = null,
        override val backgroundColor: Color? = null,
    ) : ImageSource

    data class FromUrl(
        val url: String,
        override val contentDescription: String?,
        @DrawableRes val placeholderId: Int? = null,
        @DrawableRes val errorId: Int? = null,
        override val tint: Color? = null,
        override val shape: Shape? = null,
        override val backgroundColor: Color? = null,
    ) : ImageSource
}

@Composable
fun ImageSource.toPainter() = when (this) {
    is ImageSource.FromResource -> painterResource(id = this.resId)
    is ImageSource.FromUrl -> {
        val builder = ImageRequest.Builder(LocalContext.current)
        this.placeholderId?.let { builder.placeholder(it) }
        this.errorId?.let { builder.error(it) }
        builder.data(this.url)

        rememberAsyncImagePainter(
            model = builder.build(),
        )
    }
}
