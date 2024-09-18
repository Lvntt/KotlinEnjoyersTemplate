package com.example.kotlinenjoyerstemplate.object_plan.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.object_plan.presentation.model.ObjectPlanDetailsItem
import com.example.kotlinenjoyerstemplate.ui.components.header_block.HackathonHeaderBlock
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun ObjectPlanDetails(
    model: List<ObjectPlanDetailsItem>,
    // TODO from viewModel
    onStageButtonClick: (ObjectPlanDetailsItem.Stages.Stage) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.background(HackathonTheme.colors.background.grey),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(model) { item ->
            when (item) {
                is ObjectPlanDetailsItem.GeneralInfoObject -> {
                    HackathonHeaderBlock(
                        mainPart = HackathonHeaderBlockMainPart(
                            title = HackathonHeaderBlockMainPart.Text(
                                text = "Общая информация",
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
                    GeneralInfoItem(model = item)
                }

                is ObjectPlanDetailsItem.ObjectPlanDescription -> {
                    HackathonHeaderBlock(
                        mainPart = HackathonHeaderBlockMainPart(
                            title = HackathonHeaderBlockMainPart.Text(
                                text = "Описание работ",
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
                    ObjectDescription(model = item)
                }

                is ObjectPlanDetailsItem.Stages -> {
                    HackathonHeaderBlock(
                        mainPart = HackathonHeaderBlockMainPart(
                            title = HackathonHeaderBlockMainPart.Text(
                                text = "Этапы",
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
                    StagesItem(
                        model = item,
                        onStageButtonClick = onStageButtonClick,
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}