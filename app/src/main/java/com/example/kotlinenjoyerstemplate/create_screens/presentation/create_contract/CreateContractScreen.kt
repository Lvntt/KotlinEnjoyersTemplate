package com.example.kotlinenjoyerstemplate.create_screens.presentation.create_contract

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
fun CreateContractScreen() {
    Scaffold(
        topBar = {
            CreateTopAppBar(
                title = "План",
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
                    var budget by remember { mutableStateOf(0) }
                    var plannedStartDate by remember { mutableStateOf("") }
                    var plannedEndDate by remember { mutableStateOf("") }
                    var warrantyEndDate by remember { mutableStateOf("") }

                    var nameCustomer by remember { mutableStateOf("") }
                    var phoneCustomer by remember { mutableStateOf("") }
                    var nameOrganizationCustomer by remember { mutableStateOf("") }
                    var phoneOrganizationCustomer by remember { mutableStateOf("") }
                    var addressOrganizationCustomer by remember { mutableStateOf("") }

                    var nameGeneralExecutor by remember { mutableStateOf("") }
                    var phoneGeneralExecutor by remember { mutableStateOf("") }
                    var nameOrganizationGeneralExecutor by remember { mutableStateOf("") }
                    var phoneOrganizationGeneralExecutor by remember { mutableStateOf("") }
                    var addressOrganizationGeneralExecutor by remember { mutableStateOf("") }

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
                        text = budget.toString(),
                        onValueChange = { newBudget ->
                            budget = newBudget.toInt()
                        },
                        supportingText = "Стоимость",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_budget_24dp
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
                        text = warrantyEndDate,
                        onValueChange = { newWarrantyEndDate ->
                            warrantyEndDate = newWarrantyEndDate
                        },
                        supportingText = "Гарантийный срок до...",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_warranty_end_date_24dp
                    )
                    MainCard(
                        text = nameCustomer,
                        onValueChange = { newNameCustomer ->
                            nameCustomer = newNameCustomer
                        },
                        supportingText = "Заказчик",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_name_customer_24dp
                    )
                    MainCard(
                        text = phoneCustomer,
                        onValueChange = { newPhoneCustomer ->
                            phoneCustomer = newPhoneCustomer
                        },
                        supportingText = "Телефон заказчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_phone_customer_24dp
                    )
                    MainCard(
                        text = nameOrganizationCustomer,
                        onValueChange = { newNameOrganizationCustomer ->
                            nameOrganizationCustomer = newNameOrganizationCustomer
                        },
                        supportingText = "Организация заказчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_name_24dp
                    )
                    MainCard(
                        text = phoneOrganizationCustomer,
                        onValueChange = { newPhoneOrganizationCustomer ->
                            phoneOrganizationCustomer = newPhoneOrganizationCustomer
                        },
                        supportingText = "Телефон орг. заказчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_phone_customer_24dp
                    )
                    MainCard(
                        text = addressOrganizationCustomer,
                        onValueChange = { newAddressOrganizationCustomer ->
                            addressOrganizationCustomer = newAddressOrganizationCustomer
                        },
                        supportingText = "Адрес орг. заказчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_addres_24dp
                    )
                    MainCard(
                        text = nameGeneralExecutor,
                        onValueChange = { newNameGeneralExecutor ->
                            nameGeneralExecutor = newNameGeneralExecutor
                        },
                        supportingText = "Генеральный подрядчик",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_name_general_executor_24dp
                    )
                    MainCard(
                        text = phoneGeneralExecutor,
                        onValueChange = { newPhoneGeneralExecutor ->
                            phoneGeneralExecutor = newPhoneGeneralExecutor
                        },
                        supportingText = "Телефон ген. подрядчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_phone_customer_24dp
                    )
                    MainCard(
                        text = nameOrganizationGeneralExecutor,
                        onValueChange = { newNameOrganizationGeneralExecutor ->
                            nameOrganizationGeneralExecutor = newNameOrganizationGeneralExecutor
                        },
                        supportingText = "Организация ген. подрядчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_name_24dp
                    )
                    MainCard(
                        text = phoneOrganizationGeneralExecutor,
                        onValueChange = { newPhoneOrganizationGeneralExecutor ->
                            phoneOrganizationGeneralExecutor = newPhoneOrganizationGeneralExecutor
                        },
                        supportingText = "Телефон организации ген. подрядчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_phone_customer_24dp
                    )
                    MainCard(
                        text = addressOrganizationGeneralExecutor,
                        onValueChange = { newAddressOrganizationGeneralExecutor ->
                            addressOrganizationGeneralExecutor =
                                newAddressOrganizationGeneralExecutor
                        },
                        supportingText = "Адрес организации ген. подрядчика",
                        modifier = Modifier.padding(vertical = 6.dp),
                        iconID = R.drawable.ic_addres_24dp
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
                                        status.forEach { stage ->
                                            DropdownMenuItem(
                                                onClick = {
                                                    selectedStatus = stage
                                                    expanded = false
                                                },
                                                text = {
                                                    Text(text = stage)
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
                            "Стадия 1", "Стадия 2", "Стадия 3"
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
                        text = "Добавить стадию",
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
