package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun SearchTextField(
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, HackathonTheme.colors.elements.darkGray, RoundedCornerShape(8.dp)),
        value = text,
        onValueChange = onTextChanged,
        shape = RoundedCornerShape(8.dp),
        placeholder = {
            Text(
                text = "Найти объект",
                style = HackathonTheme.typography.titles.titleM,
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search_24dp),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = HackathonTheme.colors.common.staticWhite,
            unfocusedContainerColor = HackathonTheme.colors.common.staticWhite,
            cursorColor = HackathonTheme.colors.elements.darkGray,
            focusedLeadingIconColor = HackathonTheme.colors.elements.darkGray,
            unfocusedLeadingIconColor = HackathonTheme.colors.elements.darkGray,
            focusedPlaceholderColor = HackathonTheme.colors.text.secondary.default,
            unfocusedPlaceholderColor = HackathonTheme.colors.text.secondary.default,
        ),
        singleLine = true,
        textStyle = HackathonTheme.typography.titles.titleM,
    )
}