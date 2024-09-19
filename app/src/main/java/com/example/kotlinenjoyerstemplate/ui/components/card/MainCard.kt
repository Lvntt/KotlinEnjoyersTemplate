package com.example.kotlinenjoyerstemplate.ui.components.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun MainCard(
    modifier: Modifier = Modifier,
    text: String = "TO DO",
    onValueChange: (String) -> Unit = {},
    supportingText: String = "TO DO",
    iconID: Int = R.drawable.ic_cancel_24dp
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = HackathonTheme.colors.background.white,
        )
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(24.dp),
                imageVector = ImageVector.vectorResource(id = iconID),
                contentDescription = "Test",
                tint = HackathonTheme.colors.icons.secondary
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                BasicTextField(
                    value = text,
                    onValueChange = onValueChange,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = HackathonTheme.typography.texts.textL,
                )
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp),
                    color = HackathonTheme.colors.elements.lightGray
                )
                Text(
                    text = supportingText,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontSize = HackathonTheme.typography.texts.textS.fontSize,
                    color = HackathonTheme.colors.text.secondary.default
                )
            }
        }
    }
}
