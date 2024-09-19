package com.example.kotlinenjoyerstemplate.create_screens.create_stage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.components.card.MainCard
import com.example.kotlinenjoyerstemplate.ui.components.create_topappbar.CreateTopAppBar
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun CreateStageScreen() {
    Scaffold(
        topBar = {
            CreateTopAppBar(
                title = "Стадия",
                navigationIconOnClick = { /* TO DO */ },
                actionIconOnClick = { /* TO DO */ }
            )
        },
        containerColor = HackathonTheme.colors.background.grey,
        content = { paddingValues ->
            var expanded by remember { mutableStateOf(false) }
            var selectedStatus by remember { mutableStateOf("Выберите статус") }
            val status = listOf(
                "Запланирован",
                "В процессе",
                "Отменен",
                "Завершён",
                "Приостановлен",
                "Возобнавлён"
            )

            LazyColumn(
                contentPadding = PaddingValues(
                    start = 16.dp, end = 16.dp, bottom = 20.dp, top = 14.dp
                ),
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                // Основные элементы формы
                item {
                    var name by remember { mutableStateOf("") }
                    var subExecutor by remember { mutableStateOf("") }
                    var phoneSubExecutor by remember { mutableStateOf("") }
                    var addressSubExecutor by remember { mutableStateOf("") }
                    var plannedStartDate by remember { mutableStateOf("") }
                    var plannedEndDate by remember { mutableStateOf("") }
                    var actualStartDate by remember { mutableStateOf("") }
                    var actualEndDate by remember { mutableStateOf("") }

                    MainCard(
                        text = name,
                        onValueChange = { newName ->
                            name = newName
                        },
                        supportingText = "Наименование",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_name_24dp
                    )
                    MainCard(
                        text = subExecutor,
                        onValueChange = { newSubExecutor ->
                            subExecutor = newSubExecutor
                        },
                        supportingText = "Наименование субподрядчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_name_general_executor_24dp
                    )
                    MainCard(
                        text = phoneSubExecutor,
                        onValueChange = { newPhoneSubExecutor ->
                            phoneSubExecutor = newPhoneSubExecutor
                        },
                        supportingText = "Телефон субподрядчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_phone_customer_24dp
                    )
                    MainCard(
                        text = addressSubExecutor,
                        onValueChange = { newAddressSubExecutor ->
                            addressSubExecutor = newAddressSubExecutor
                        },
                        supportingText = "Адрес субподрядчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_addres_24dp
                    )
                    MainCard(
                        text = plannedStartDate,
                        onValueChange = { newPlannedStartDate ->
                            plannedStartDate = newPlannedStartDate
                        },
                        supportingText = "Планируемая дата начала",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_start_date_24dp
                    )
                    MainCard(
                        text = plannedEndDate,
                        onValueChange = { newPlannedEndDate ->
                            plannedEndDate = newPlannedEndDate
                        },
                        supportingText = "Планируемая дата окончания",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_planned_end_date_24dp
                    )
                    MainCard(
                        text = actualStartDate,
                        onValueChange = { newActualStartDate ->
                            actualStartDate = newActualStartDate
                        },
                        supportingText = "Фактическая дата начала",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_start_date_24dp
                    )
                    MainCard(
                        text = actualEndDate,
                        onValueChange = { newActualEndDate ->
                            actualEndDate = newActualEndDate
                        },
                        supportingText = "Фактическая дата окончания",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_planned_end_date_24dp
                    )

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = HackathonTheme.colors.background.white,
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 12.dp
                            )
                        ) {
                            Icon(
                                modifier = Modifier
                                    .padding(end = 10.dp)
                                    .size(24.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_status_24dp),
                                contentDescription = "Test",
                                tint = HackathonTheme.colors.icons.secondary
                            )
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Box {
                                    Text(
                                        text = selectedStatus,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable { expanded = true },
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    DropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false },
                                        containerColor = HackathonTheme.colors.background.white,
                                    ) {
                                        status.forEach { status ->
                                            DropdownMenuItem(
                                                onClick = {
                                                    selectedStatus = status
                                                    expanded = false
                                                },
                                                text = {
                                                    Text(text = status)
                                                }
                                            )
                                        }
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 2.dp),
                                    color = HackathonTheme.colors.elements.lightGray
                                )
                                Text(
                                    text = "Статус выполнения",
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    fontSize = HackathonTheme.typography.texts.textS.fontSize,
                                    color = HackathonTheme.colors.text.secondary.default
                                )
                            }
                        }
                    }
                }


                // Список стадий и кнопка "Добавить стадию"
                item {
                    val plans = remember {
                        mutableStateListOf<String>(
                            "Документ 1", "Документ 2", "Документ 3"
                        )
                    }

                    plans.forEach { plan ->
                        HackathonButton.Added(
                            onClick = { /* TO DO */ },
                            text = plan,
                            icon = HackathonButtonIcon(
                                resId = R.drawable.ic_chevron_right_24dp,
                                sizeDp = 24,
                                tintColor = HackathonTheme.colors.icons.primary
                            ),
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }

                    HackathonButton.L(
                        onClick = { /* TO DO */ },
                        text = "Добавить документ",
                        icon = HackathonButtonIcon(
                            resId = R.drawable.ic_add_24db,
                            sizeDp = 24,
                            tintColor = HackathonTheme.colors.icons.primary
                        ),
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }

                // Кнопка "Сохранить"
                item {
                    HackathonButton.L(
                        text = "Сохранить",
                        onClick = { /* TO DO */ },
                        isFillMaxWidth = true,
                        buttonColors = hackathonButtonColors(
                            containerColor = HackathonTheme.colors.common.accent,
                            disabledContainerColor = HackathonTheme.colors.common.accent,
                            contentColor = HackathonTheme.colors.common.staticWhite,
                            disabledContentColor = HackathonTheme.colors.common.staticWhite
                        ),
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
        }
    )
}
