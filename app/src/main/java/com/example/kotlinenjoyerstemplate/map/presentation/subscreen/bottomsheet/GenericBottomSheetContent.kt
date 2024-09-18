package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun ColumnScope.GenericBottomSheetContent(
    title: String,
    items: List<BottomSheetItem>,
) {
    Text(
        text = title,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        color = HackathonTheme.colors.text.primary.default,
        style = HackathonTheme.typography.titles.titleL,
        textAlign = TextAlign.Start,
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .background(
                HackathonTheme.colors.common.staticWhite,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 12.dp, horizontal = 16.dp),
    ) {
        items.forEach { item ->
            Row(modifier = Modifier.padding(vertical = 12.dp).clickable { item.onClick() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(item.iconResId),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = HackathonTheme.colors.icons.secondary,
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = item.title,
                    modifier = Modifier.fillMaxWidth(),
                    color = HackathonTheme.colors.text.primary.default,
                    style = HackathonTheme.typography.texts.textL,
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}