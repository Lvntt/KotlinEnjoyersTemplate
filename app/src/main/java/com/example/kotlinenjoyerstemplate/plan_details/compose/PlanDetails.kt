package com.example.kotlinenjoyerstemplate.plan_details.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.plan_details.model.PlanDetailsItem
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.header_block.HackathonHeaderBlock
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun PlanDetails(
    model: List<PlanDetailsItem>,
    topBar: PlanDetailsItem.TopBar,
    onContractClick: (PlanDetailsItem.Contracts.Contract) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            HackathonBlock(
                mainPart = HackathonBlockMainPart(
                    title = HackathonBlockMainPart.Text(
                        text = topBar.planName,
                        style = HackathonTheme.typography.titles.titleL,
                    ),
                    subtitle = HackathonBlockMainPart.Text(
                        text = topBar.planDescription,
                        style = HackathonTheme.typography.titles.titleS,
                    ),
                    status = HackathonBlockMainPart.Text(
                        text = topBar.planStatus.text,
                        style = HackathonTheme.typography.titles.titleS,
                        color = colorResource(id = topBar.planStatus.colorId),
                    ),
                ),
                leftPart = HackathonBlockLeftPart.Icon(
                    source = ImageSource.FromResource(
                        resId = R.drawable.ic_arrow_back_24dp,
                        contentDescription = null,
                    ),
                    sizeDp = 24,
                    onClick = onBack,
                ),
                shape = RoundedCornerShape(
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp,
                ),
                isFillMaxWidth = true,
                backgroundColor = HackathonTheme.colors.background.grey,
            )
        }
    ) { paddings ->
        LazyColumn(
            modifier = modifier
                .background(HackathonTheme.colors.background.grey)
                .padding(paddings),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(model) { item ->
                when (item) {
                    is PlanDetailsItem.Header -> {
                        HackathonHeaderBlock(
                            mainPart = HackathonHeaderBlockMainPart(
                                title = HackathonHeaderBlockMainPart.Text(
                                    text = item.title,
                                )
                            ),
                            sidePadding = PaddingValues(
                                start = 16.dp,
                                end = 16.dp,
                                top = 16.dp,
                                bottom = 8.dp,
                            ),
                            backgroundColor = HackathonTheme.colors.background.grey,
                        )
                    }

                    is PlanDetailsItem.PlanStatus -> {
                        PlanStatusItem(model = item)
                    }

                    is PlanDetailsItem.Contracts -> {
                        ContractsItem(
                            model = item,
                            onContractClick = onContractClick,
                        )
                    }

                    is PlanDetailsItem.GeneralObjectInfo -> {
                        GeneralObjectInfoItem(model = item)
                    }

                    is PlanDetailsItem.TopBar -> Unit
                }
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}