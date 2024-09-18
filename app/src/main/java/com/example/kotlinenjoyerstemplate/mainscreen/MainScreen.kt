package com.example.kotlinenjoyerstemplate.mainscreen

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.map.MapScreen
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.components.searchtext.SearchTextField
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    var searchText by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            HackathonButton.M(
                onClick = {
                    focusManager.clearFocus()
                },
                text = "Добавить работы",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
                icon = HackathonButtonIcon(
                    resId = R.drawable.add_icon,
                    sizeDp = 16,
                    tintColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        content = {
            MapScreen(
                modifier = Modifier.padding(it),
                focusManager = focusManager,
            )
            SearchTextField()
        }
    )
}
