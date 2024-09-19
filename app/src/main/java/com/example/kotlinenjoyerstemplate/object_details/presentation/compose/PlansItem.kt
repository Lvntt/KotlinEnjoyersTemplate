package com.example.kotlinenjoyerstemplate.object_details.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.object_details.presentation.model.ObjectDetailsItem
import com.example.kotlinenjoyerstemplate.ui.common.FrameRounded
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockRightPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun PlansItem(
    model: ObjectDetailsItem.Plans,
    onPlanClick: (ObjectDetailsItem.Plans.Plan) -> Unit,
    modifier: Modifier = Modifier,
) = FrameRounded(
    modifier = modifier,
    sidePadding = PaddingValues(vertical = 12.dp),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        model.plans.forEach { plan ->
            HackathonBlock(
                mainPart = HackathonBlockMainPart(
                    title = HackathonBlockMainPart.Text(
                        text = plan.name,
                    ),
                    subtitle = plan.description?.let {
                        HackathonBlockMainPart.Text(
                            text = plan.description,
                        )
                    },
                    status = HackathonBlockMainPart.Text(
                        text = plan.status.text,
                        color = colorResource(id = plan.status.colorId),
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
                rightPart = HackathonBlockRightPart.Icon(
                    source = ImageSource.FromResource(
                        resId = R.drawable.ic_chevron_right_24dp,
                        contentDescription = null,
                    ),
                    sizeDp = 24,
                    onClick = { onPlanClick(plan) },
                ),
                isFillMaxWidth = true,
                innerPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            )
        }
    }
}