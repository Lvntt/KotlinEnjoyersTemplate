package com.example.kotlinenjoyerstemplate.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlinenjoyerstemplate.common.StatusWorkEnum
import com.example.kotlinenjoyerstemplate.contract_details.presentation.compose.ContractDetails
import com.example.kotlinenjoyerstemplate.contract_details.presentation.model.ObjectContractItem
import com.example.kotlinenjoyerstemplate.object_details.presentation.compose.ObjectDetails
import com.example.kotlinenjoyerstemplate.object_details.presentation.model.ObjectDetailsItem
import com.example.kotlinenjoyerstemplate.plan_details.compose.PlanDetails
import com.example.kotlinenjoyerstemplate.plan_details.model.PlanDetailsItem

sealed interface ObjectDetailsNavDestination : NavDestination {

    data object ObjectDetailsScreen : RootNavDestination("ObjectDetailsScreen")

    data object ContractDetailsScreen : RootNavDestination("ContractDetailsScreen")

    data object PlanDetailsScreen : RootNavDestination("PlanDetailsScreen")
}

@Composable
fun ObjectDetailsNavigation(navController: NavHostController) {
    NavHost(
        modifier = Modifier.fillMaxHeight(),
        navController = navController,
        startDestination = ObjectDetailsNavDestination.ObjectDetailsScreen.getDestination(),
    ) {
        composable(route = ObjectDetailsNavDestination.ObjectDetailsScreen.getDestination()) {
            val generalInfoHeader = ObjectDetailsItem.Header(
                title = "Информация об объекте",
            )
            val generalInfoModel = ObjectDetailsItem.GeneralObjectInfo(
                name = "ул. Комарова - ул. Белобородова",
                address = "МО, г. Мытищи",
            )
            val plansHeader = ObjectDetailsItem.Header(
                title = "Планы",
            )
            val plansModel = ObjectDetailsItem.Plans(
                plans = listOf(
                    ObjectDetailsItem.Plans.Plan(
                        id = "",
                        name = "Плановый ремонт дороги",
                        description = "Ежегодный ремонт 2024",
                        status = StatusWorkEnum.CANCELLED,
                    ),
                    ObjectDetailsItem.Plans.Plan(
                        id = "",
                        name = "Срочный ремонт дороги",
                        description = "Ремонт ямы",
                        status = StatusWorkEnum.IN_PROCESS,
                    ),
                    ObjectDetailsItem.Plans.Plan(
                        id = "",
                        name = "Плановый ремонт дороги",
                        description = "Ежегодный ремонт 2025",
                        status = StatusWorkEnum.COMPLETED,
                    ),
                    ObjectDetailsItem.Plans.Plan(
                        id = "",
                        name = "Плановый ремонт дороги",
                        description = "Ежегодный ремонт 2026",
                        status = StatusWorkEnum.PLANNED,
                    ),
                )
            )
            val model = listOf(
                generalInfoHeader,
                generalInfoModel,
                plansHeader,
                plansModel,
            )
            ObjectDetails(
                model = model,
                onPlanClick = { plan ->
                    // TODO getNavigationRoute with plan.id
                    navController.navigate(ObjectDetailsNavDestination.PlanDetailsScreen.getDestination())
                }
            )
        }

        composable(route = ObjectDetailsNavDestination.PlanDetailsScreen.getDestination()) {
            val topBarModel = PlanDetailsItem.TopBar(
                planName = "Срочный ремонт дороги",
                planDescription = "Ремонт ямы",
                planStatus = StatusWorkEnum.IN_PROCESS,
            )
            val planStatusHeader = PlanDetailsItem.Header(
                title = "Статус плана",
            )
            val planStatusModel = PlanDetailsItem.PlanStatus(
                completePercentage = "75%",
                creationDate = "18 сентября 2024",
            )
            val contractsHeader = PlanDetailsItem.Header(
                title = "Контракты",
            )
            val contractsModel = PlanDetailsItem.Contracts(
                contracts = listOf(
                    PlanDetailsItem.Contracts.Contract(
                        id = "",
                        name = "Устройство транспортной развязки",
                        generalExecutorName = "ООО «Спектр»",
                    ),
                    PlanDetailsItem.Contracts.Contract(
                        id = "",
                        name = "Устройство транспортной развязки",
                        generalExecutorName = "ООО «Спектр»",
                    ),
                )
            )
            val generalInfoHeader = PlanDetailsItem.Header(
                title = "Информация об объекте",
            )
            val generalInfoModel = PlanDetailsItem.GeneralObjectInfo(
                name = "ул. Комарова - ул. Белобородова",
                address = "МО, г. Мытищи",
            )
            val model = listOf(
                planStatusHeader,
                planStatusModel,
                contractsHeader,
                contractsModel,
                generalInfoHeader,
                generalInfoModel,
            )

            PlanDetails(
                model = model,
                topBar = topBarModel,
                onContractClick = { contract ->
                    // TODO getNavigationRoute with contract.id
                    navController.navigate(ObjectDetailsNavDestination.ContractDetailsScreen.getDestination())
                },
                onBack = {
                    navController.popBackStack()
                },
            )
        }

        composable(route = ObjectDetailsNavDestination.ContractDetailsScreen.getDestination()) {
            val stages = listOf(
                ObjectContractItem.Stages.Stage(
                    name = "Планирование",
                    status = StatusWorkEnum.COMPLETED,
                    plannedStartDate = "10 июля 2019",
                    plannedEndDate = "1 октября 2019",
                    actualStartDate = "17 июля 2019",
                    actualEndDate = "1 октября 2019",
                    subExecutorName = "ООО «Спектр»",
                    subExecutorPhone = "+7 (934) 587-65-09",
                    subExecutorAddress = "г. Москва, ул. Пушкина, д.1 к. 69",
                    documents = listOf(
                        ObjectContractItem.Stages.Document(
                            title = "Паспорт объекта",
                            url = "https://storage.yandexcloud.net/hackathon-its/Reliability.docx?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=YCAJEPpK5UVZoEUcVh9UgRy79/20240918/ru-central1/s3/aws4_request&X-Amz-Date=20240918T085204Z&X-Amz-Expires=223200&X-Amz-Signature=ADE2164BBC96818C6080302CB37E1CCF6B7343C93184BD80CE86A00FF194C33C&X-Amz-SignedHeaders=host",
                            extension = "docx",
                        ),
                        ObjectContractItem.Stages.Document(
                            title = "Фото объекта",
                            url = "https://storage.yandexcloud.net/hackathon-its/Reliability.docx?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=YCAJEPpK5UVZoEUcVh9UgRy79/20240918/ru-central1/s3/aws4_request&X-Amz-Date=20240918T085204Z&X-Amz-Expires=223200&X-Amz-Signature=ADE2164BBC96818C6080302CB37E1CCF6B7343C93184BD80CE86A00FF194C33C&X-Amz-SignedHeaders=host",
                            extension = "docx",
                        ),
                    ),
                ),
                ObjectContractItem.Stages.Stage(
                    name = "Название второго этапа",
                    status = StatusWorkEnum.COMPLETED,
                    plannedStartDate = "15 сентября 2024",
                    plannedEndDate = "15 сентября 2024",
                    actualStartDate = "15 сентября 2024",
                    actualEndDate = "15 сентября 2024",
                    subExecutorName = "ООО «Спектр»",
                    subExecutorPhone = "+7 (934) 587-65-09",
                    subExecutorAddress = "г. Москва, ул. Пушкина, д.1 к. 69",
                    documents = listOf(
                        ObjectContractItem.Stages.Document(
                            title = "Название документа",
                            url = "",
                            extension = "",
                        ),
                        ObjectContractItem.Stages.Document(
                            title = "Другое название документа",
                            url = "",
                            extension = "",
                        ),
                    ),
                ),
                ObjectContractItem.Stages.Stage(
                    name = "Название третьего этапа",
                    status = StatusWorkEnum.PLANNED,
                    plannedStartDate = "10 июля 2019",
                    plannedEndDate = "1 октября 2019",
                    actualStartDate = "17 июля 2019",
                    actualEndDate = "1 октября 2019",
                    subExecutorName = "ООО «Спектр»",
                    subExecutorPhone = "+7 (934) 587-65-09",
                    subExecutorAddress = "г. Москва, ул. Пушкина, д.1 к. 69",
                    documents = listOf(
                        ObjectContractItem.Stages.Document(
                            title = "Паспорт объекта",
                            url = "",
                            extension = "",
                        ),
                        ObjectContractItem.Stages.Document(
                            title = "Фото объекта",
                            url = "",
                            extension = "",
                        ),
                    ),
                ),
            )
            var chosenStage by remember { mutableStateOf(stages[0]) }
            val stageModel = ObjectContractItem.Stages(
                stages = stages,
                chosenStage = chosenStage,
            )
            val generalInfoModel = ObjectContractItem.GeneralObjectInfo(
                name = "ул. Комарова - ул. Белобородова",
                address = "МО, г. Мытищи",
            )
            val contractDescriptionModel = ObjectContractItem.ContractDescription(
                budget = "300.000 ₽ ",
                customerName = "Муниципальное казенное учреждение «УКС ЖКХ»",
                generalExecutorName = "ООО «Спектр»",
                plannedStartDate = "10 июля 2019",
                plannedEndDate = "1 октября 2019",
                warrantyEndDate = "1 октября 2019",
            )
            val contactsModel = ObjectContractItem.Contacts(
                generalExecutorPhone = "+7 (934) 587-65-09",
                customerPhone = "+7 (912) 680-00-50",
            )
            val stagesHeader = ObjectContractItem.Header(
                title = "Этапы работ"
            )
            val contractDescriptionHeader = ObjectContractItem.Header(
                title = "Описание контракта"
            )
            val contactsHeader = ObjectContractItem.Header(
                title = "Контакты"
            )
            val generalInfoHeader = ObjectContractItem.Header(
                title = "Информация об объекте"
            )
            ContractDetails(
                model = listOf(
                    stagesHeader,
                    stageModel,
                    contractDescriptionHeader,
                    contractDescriptionModel,
                    contactsHeader,
                    contactsModel,
                    generalInfoHeader,
                    generalInfoModel,
                ),
                onStageButtonClick = { chosenStage = it },
                topBar = ObjectContractItem.TopBar(
                    contractName = "Устройство транспортной развязки",
                    generalExecutorName = "ООО «Спектр»",
                ),
                onBack = {
                    navController.popBackStack()
                },
            )
        }
    }
}