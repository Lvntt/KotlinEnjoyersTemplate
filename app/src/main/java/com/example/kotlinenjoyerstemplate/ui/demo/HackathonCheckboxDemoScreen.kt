package com.example.kotlinenjoyerstemplate.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.components.checkbox.HackathonCheckbox
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonCheckboxDemoScreen(onBack: () -> Unit) = BaseDemoScreen(
    elementName = "HackathonCheckbox",
    onBack = onBack,
) {
    var isChecked by remember { mutableStateOf(false) }
    var isChecked2 by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HackathonTheme.colors.background.grey),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HackathonCheckbox(
            isChecked = isChecked,
            onCheckedChange = { isChecked = it },
        )
        HackathonCheckbox(
            isChecked = isChecked2,
            onCheckedChange = { isChecked2 = it },
        )
    }
}