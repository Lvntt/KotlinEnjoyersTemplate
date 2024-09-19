package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun ObjectMarker(progress: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(
                color = when (progress) {
                    in 0..49 -> HackathonTheme.colors.status.mapPlanned
                    in 50..74 -> HackathonTheme.colors.status.mapInProgress
                    else -> HackathonTheme.colors.status.mapSuccess
                },
                shape = RoundedCornerShape(8.dp),
            )
            .border(
                width = 2.dp,
                color = HackathonTheme.colors.elements.darkGray,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(horizontal = 6.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_handyman_24dp),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = HackathonTheme.colors.icons.primary,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "$progress%",
            color = HackathonTheme.colors.text.primary.default,
            style = HackathonTheme.typography.titles.titleS,
        )
    }
}

@Composable
fun ObjectMarkerPlaceholder(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(
                color = HackathonTheme.colors.status.planned,
                shape = RoundedCornerShape(8.dp),
            )
            .border(
                width = 2.dp,
                color = HackathonTheme.colors.elements.darkGray,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(horizontal = 6.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_info_24dp),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = HackathonTheme.colors.icons.primary,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Инфо",
            color = HackathonTheme.colors.text.primary.default,
            style = HackathonTheme.typography.titles.titleS,
        )
    }
}