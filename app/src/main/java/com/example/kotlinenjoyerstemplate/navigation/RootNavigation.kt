package com.example.kotlinenjoyerstemplate.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.navigation.BottomSheetNavigator
import androidx.compose.material.navigation.ModalBottomSheetLayout
import androidx.compose.material.navigation.bottomSheet
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlinenjoyerstemplate.common.StatusWorkEnum
import com.example.kotlinenjoyerstemplate.object_plan.presentation.compose.ContractDetails
import com.example.kotlinenjoyerstemplate.object_plan.presentation.model.ObjectContractItem
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

sealed class RootNavDestination(override val baseRoute: String) : NavDestination {

     data object MapScreen : RootNavDestination("MapScreen")

     data object ObjectBottomSheet : RootNavDestination("ObjectBottomSheet")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootNavigation(
    bottomSheetNavigator: BottomSheetNavigator,
    navController: NavHostController,
    onCloseApp: () -> Unit,
) {

    BackHandler {
        if (navController.previousBackStackEntry == null) {
            onCloseApp()
        } else {
            navController.popBackStack()
        }
    }

    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
    ) {
        NavHost(
            navController = navController,
            startDestination = RootNavDestination.MapScreen.getDestination(),
        ) {
            composable(route = RootNavDestination.MapScreen.getDestination()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = RootNavDestination.MapScreen.getDestination())
                        Button(
                            onClick = {
                                navController.navigate(RootNavDestination.ObjectBottomSheet.getNavigationRoute())
                            }
                        ) {
                            Text(text = "Open Bottom Sheet")
                        }
                    }
                }
            }
            bottomSheet(route = RootNavDestination.ObjectBottomSheet.getDestination()) {
                val sheetState = rememberModalBottomSheetState(
                    skipPartiallyExpanded = false,
                )
                ModalBottomSheet(
                    modifier = Modifier.fillMaxHeight(),
                    sheetState = sheetState,
                    onDismissRequest = { navController.popBackStack() },
                    containerColor = HackathonTheme.colors.background.grey,
                ) {
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
                        )
                    )
                }
            }
        }
    }
}