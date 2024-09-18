package com.example.kotlinenjoyerstemplate.object_details.presentation.compose

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
import com.example.kotlinenjoyerstemplate.object_details.presentation.model.ObjectDetailsItem
import com.example.kotlinenjoyerstemplate.ui.components.header_block.HackathonHeaderBlock
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun ObjectDetails(
    model: List<ObjectDetailsItem>,
    onPlanClick: (ObjectDetailsItem.Plans.Plan) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .background(HackathonTheme.colors.background.grey),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(model) { item ->
            when (item) {
                is ObjectDetailsItem.Header -> {
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

                is ObjectDetailsItem.GeneralObjectInfo -> {
                    GeneralObjectInfoItem(model = item)
                }

                is ObjectDetailsItem.Plans -> {
                    PlansItem(
                        model = item,
                        onPlanClick = onPlanClick,
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}