package com.example.kotlinenjoyerstemplate.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.map.MapScreen
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart.Text
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.maps.extension.style.expressions.dsl.generated.color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    var searchText by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            HackathonButton.M(
                onClick = {},
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
                modifier = Modifier.padding(it)
            )
        }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 32.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = searchText,
            onValueChange = {
                searchText = it
                // onSearch(it)
            },
            placeholder = { Text("Поиск объекта") },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(

            ),
            singleLine = true,
        )
    }
}
