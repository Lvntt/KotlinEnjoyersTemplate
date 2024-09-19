package com.example.kotlinenjoyerstemplate.create_screens.presentation.create_object

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.create_screens.presentation.model.ObjectCreationEvent
import com.example.kotlinenjoyerstemplate.create_screens.presentation.model.ObjectCreationState
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.components.card.MainCard
import com.example.kotlinenjoyerstemplate.ui.components.create_topappbar.CreateTopAppBar
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun CreateObjectScreen(
    state: ObjectCreationState,
    onEvent: (ObjectCreationEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            CreateTopAppBar(
                title = "Объект",
                navigationIconOnClick = { onEvent(ObjectCreationEvent.BackClicked) },
                actionIconOnClick = { onEvent(ObjectCreationEvent.CloseClicked) }
            )
        },
        containerColor = HackathonTheme.colors.background.grey,
        content = {
            Column(
                Modifier
                    .padding(it)
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 20.dp,
                        top = 14.dp
                    )
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Column {
                        MainCard(
                            text = state.objectInfo.name,
                            onValueChange = { onEvent(ObjectCreationEvent.ObjectInfoTitleChanged(it)) },
                            supportingText = "Наименование",
                            modifier = Modifier.padding(
                                vertical = 6.dp
                            ),
                            iconID = R.drawable.ic_name_24dp
                        )
                        MainCard(
                            text = state.objectInfo.address,
                            onValueChange = { onEvent(ObjectCreationEvent.ObjectInfoAddressChanged(it)) },
                            supportingText = "Адрес",
                            modifier = Modifier.padding(
                                vertical = 6.dp
                            ),
                            iconID = R.drawable.ic_addres_24dp
                        )
                    }
                    Column(
                        modifier = Modifier.padding(
                            top = 10.dp,
                            bottom = 16.dp
                        )
                    ) {
                        LazyColumn {
                            items(state.plans.size) { index ->
                                HackathonButton.Added(
                                    onClick = { onEvent(ObjectCreationEvent.PlanSelected(index)) },
                                    text = state.plans[index].name,
                                    icon = HackathonButtonIcon(
                                        resId = R.drawable.ic_chevron_right_24dp,
                                        sizeDp = 24,
                                        tintColor = HackathonTheme.colors.icons.primary
                                    ),
                                    modifier = Modifier.padding(vertical = 4.dp)
                                )
                            }

                        }
                        HackathonButton.L(
                            onClick = { onEvent(ObjectCreationEvent.PlanCreated) },
                            text = "Добавить план",
                            icon = HackathonButtonIcon(
                                resId = R.drawable.ic_add_24db,
                                sizeDp = 24,
                                tintColor = HackathonTheme.colors.icons.primary
                            ),
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
                HackathonButton.L(
                    text = "Сохранить",
                    onClick = { onEvent(ObjectCreationEvent.SaveClicked) },
                    isFillMaxWidth = true,
                    buttonColors = hackathonButtonColors(
                        containerColor = HackathonTheme.colors.common.accent,
                        disabledContainerColor = HackathonTheme.colors.common.accent,
                        contentColor = HackathonTheme.colors.common.staticWhite,
                        disabledContentColor = HackathonTheme.colors.common.staticWhite
                    )
                )
            }
        }
    )
}