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
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockRightPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun ContractsItem(
    model: PlanDetailsItem.Contracts,
    onContractClick: (PlanDetailsItem.Contracts.Contract) -> Unit,
    modifier: Modifier = Modifier,
) = FrameRounded(
    modifier = modifier,
    sidePadding = PaddingValues(vertical = 12.dp),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        model.contracts.forEach { contract ->
            HackathonBlock(
                mainPart = HackathonBlockMainPart(
                    title = HackathonBlockMainPart.Text(
                        text = contract.name,
                    ),
                    subtitle = HackathonBlockMainPart.Text(
                        text = contract.generalExecutorName,
                    ),
                ),
                leftPart = HackathonBlockLeftPart.Icon(
                    source = ImageSource.FromResource(
                        resId = R.drawable.ic_contract_24dp,
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
                    onClick = { onContractClick(contract) },
                ),
                isFillMaxWidth = true,
                innerPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            )
        }
    }
}