package com.example.kotlinenjoyerstemplate.object_plan.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.object_plan.presentation.model.ObjectContractItem
import com.example.kotlinenjoyerstemplate.ui.common.FrameRounded
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun ContactsItem(
    model: ObjectContractItem.Contacts,
    modifier: Modifier = Modifier,
) = FrameRounded(modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = model.generalExecutorPhone,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Генеральный подрядчик",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_call_24dp,
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
                    text = model.customerPhone,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Заказчик",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_call_24dp,
                    contentDescription = null,
                    tint = HackathonTheme.colors.icons.secondary,
                ),
                sizeDp = 24,
            ),
            innerPadding = PaddingValues(vertical = 12.dp),
        )
    }
}