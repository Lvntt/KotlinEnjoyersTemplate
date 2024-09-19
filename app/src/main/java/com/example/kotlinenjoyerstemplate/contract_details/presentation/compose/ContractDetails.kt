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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.contract_details.ContractDetailsUiState
import com.example.kotlinenjoyerstemplate.contract_details.presentation.model.ContractDetailsItem
import com.example.kotlinenjoyerstemplate.contract_details.presentation.viewmodel.ContractDetailsViewModel
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.error_block.HackathonErrorScreen
import com.example.kotlinenjoyerstemplate.ui.components.header_block.HackathonHeaderBlock
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.loader_block.HackathonLoaderScreen
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun ContractDetails(
    viewModel: ContractDetailsViewModel,
    onStageButtonClick: (ContractDetailsItem.Stages.Stage) -> Unit,
    onBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        ContractDetailsUiState.Loading -> HackathonLoaderScreen()

        is ContractDetailsUiState.Content -> {
            val model = (uiState as ContractDetailsUiState.Content).model
            val topBar = (uiState as ContractDetailsUiState.Content).topBar

            ContractDetails(
                model = model,
                topBar = topBar,
                onStageButtonClick = onStageButtonClick,
                onBack = onBack,
            )
        }

        ContractDetailsUiState.Error -> HackathonErrorScreen(
            onRetry = viewModel::loadData,
        )
    }
}

@Composable
fun ContractDetails(
    topBar: ContractDetailsItem.TopBar,
    model: List<ContractDetailsItem>,
    onStageButtonClick: (ContractDetailsItem.Stages.Stage) -> Unit,
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
                    is ContractDetailsItem.Header -> {
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

                    is ContractDetailsItem.GeneralInfoDetails -> {
                        GeneralObjectInfoItem(model = item)
                    }

                    is ContractDetailsItem.ContractDetailsDescription -> {
                        ContractDescriptionItem(model = item)
                    }

                    is ContractDetailsItem.Stages -> {
                        StagesItem(
                            model = item,
                            onStageButtonClick = onStageButtonClick,
                        )
                    }

                    is ContractDetailsItem.Contacts -> {
                        ContactsItem(model = item)
                    }

                    is ContractDetailsItem.TopBar -> Unit
                }
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}