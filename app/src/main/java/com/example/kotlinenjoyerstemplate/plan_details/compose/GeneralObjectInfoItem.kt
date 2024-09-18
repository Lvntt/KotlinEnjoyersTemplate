package com.example.kotlinenjoyerstemplate.plan_details.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.plan_details.model.PlanDetailsItem
import com.example.kotlinenjoyerstemplate.ui.common.FrameRounded
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun GeneralObjectInfoItem(
    model: PlanDetailsItem.GeneralObjectInfo,
    modifier: Modifier = Modifier
) = FrameRounded(modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = model.name,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Наименование объекта",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_id_card_24dp,
                    contentDescription = null,
                    tint = HackathonTheme.colors.icons.secondary,
                ),
                sizeDp = 24,
            ),
            innerPadding = PaddingValues(vertical = 12.dp),
        )
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = model.address,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Адрес объекта",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_location_on_24dp,
                    contentDescription = null,
                    tint = HackathonTheme.colors.icons.secondary,
                ),
                sizeDp = 24,
            ),
            innerPadding = PaddingValues(vertical = 12.dp),
        )
    }
}