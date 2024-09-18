package com.example.kotlinenjoyerstemplate.contract_details.presentation.compose

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
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.contract_details.presentation.model.ObjectContractItem
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.header_block.HackathonHeaderBlock
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun ContractDetails(
    topBar: ObjectContractItem.TopBar,
    model: List<ObjectContractItem>,
    onStageButtonClick: (ObjectContractItem.Stages.Stage) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            HackathonBlock(
                mainPart = HackathonBlockMainPart(
                    title = HackathonBlockMainPart.Text(
                        text = topBar.contractName,
                        style = HackathonTheme.typography.titles.titleL,
                    ),
                    subtitle = HackathonBlockMainPart.Text(
                        text = topBar.generalExecutorName,
                        style = HackathonTheme.typography.titles.titleS,
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
                    is ObjectContractItem.Header -> {
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

                    is ObjectContractItem.GeneralObjectInfo -> {
                        GeneralObjectInfoItem(model = item)
                    }

                    is ObjectContractItem.ContractDescription -> {
                        ContractDescriptionItem(model = item)
                    }

                    is ObjectContractItem.Stages -> {
                        StagesItem(
                            model = item,
                            onStageButtonClick = onStageButtonClick,
                        )
                    }

                    is ObjectContractItem.Contacts -> {
                        ContactsItem(model = item)
                    }

                    is ObjectContractItem.TopBar -> Unit
                }
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}