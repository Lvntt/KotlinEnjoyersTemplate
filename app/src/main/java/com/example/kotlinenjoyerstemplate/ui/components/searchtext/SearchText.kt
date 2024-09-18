package com.example.kotlinenjoyerstemplate.ui.components.searchtext

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme


@Composable
fun SearchTextField() {
    var text by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 28.dp
            ),
        contentAlignment = Alignment.TopCenter,
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .focusRequester(focusRequester),
            value = text,
            onValueChange = { text = it },
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text("Найти объект")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "search icon"
                )
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = HackathonTheme.colors.common.staticWhite,
                unfocusedContainerColor = HackathonTheme.colors.common.staticWhite,
                cursorColor = HackathonTheme.colors.common.accent,
                focusedLeadingIconColor = HackathonTheme.colors.common.accent,
                unfocusedLeadingIconColor = HackathonTheme.colors.common.accent,
                focusedPlaceholderColor = HackathonTheme.colors.text.secondary.disabled
            ),
            singleLine = true
        )
    }
}

