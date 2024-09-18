package com.example.kotlinenjoyerstemplate.object_info.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.object_info.presentation.model.ObjectPlanDetailsItem
import com.example.kotlinenjoyerstemplate.ui.common.FrameRounded
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun ObjectDescription(
    model: ObjectPlanDetailsItem.ObjectPlanDescription,
    modifier: Modifier = Modifier,
) = FrameRounded(modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = model.budget,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Стоимость",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_paid_24dp,
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
                    text = model.customer,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Заказчик",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_person_24dp,
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
                    text = model.contractor,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Генеральный подрядчик",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_handyman_24dp,
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
                    text = model.plannedStartDate,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Начало работ, запланированное",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_event_24dp,
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
                    text = model.actualStartDate,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Начало работ, фактическое",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_event_24dp,
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
                    text = model.plannedEndDate,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Окончание работ, запланированное",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_event_available_24dp,
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
                    text = model.actualEndDate,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Окончание работ, фактическое",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_event_available_24dp,
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
                    text = model.warrantyEndDate,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Гарантийный срок, до",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_verified_user_24dp,
                    contentDescription = null,
                    tint = HackathonTheme.colors.icons.secondary,
                ),
                sizeDp = 24,
            ),
            innerPadding = PaddingValues(vertical = 12.dp),
        )
    }
}