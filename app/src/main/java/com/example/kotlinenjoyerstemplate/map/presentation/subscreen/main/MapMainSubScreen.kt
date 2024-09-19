package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.common.StatusWorkEnum
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.ZoneRenderMode
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenStore
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.components.ObjectMarker
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.components.ObjectMarkerPlaceholder
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.components.SearchTextField
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainState
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.MapObjectZonesSubScreen
import com.example.kotlinenjoyerstemplate.object_details.presentation.compose.ObjectDetails
import com.example.kotlinenjoyerstemplate.object_details.presentation.model.ObjectDetailsItem
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.maps.CameraState
import com.mapbox.maps.extension.compose.MapboxMapComposable
import com.mapbox.maps.extension.compose.MapboxMapScope
import com.mapbox.maps.extension.compose.annotation.ViewAnnotation
import com.mapbox.maps.extension.compose.annotation.generated.PolygonAnnotation
import com.mapbox.maps.extension.compose.annotation.generated.PolylineAnnotation
import com.mapbox.maps.viewannotation.geometry
import com.mapbox.maps.viewannotation.viewAnnotationOptions

class MapMainSubScreen(
    private val store: MapSubScreenStore,
    override val viewModel: MapMainViewModel,
) :
    MapSubScreen<MapMainState, MapMainEvent, MapMainEffect> {

    @OptIn(ExperimentalMaterial3Api::class)
    override suspend fun handleEffects(sheetState: BottomSheetScaffoldState, context: Context) {
        viewModel.effects.collect { effect ->
            when (effect) {
                MapMainEffect.NavigateToNewObject -> store.navigateWithParams<MapObjectZonesSubScreen>(
                    Unit
                )

                MapMainEffect.OpenBottomSheet -> sheetState.bottomSheetState.show()
                MapMainEffect.ShowLoadingError -> Toast.makeText(
                    context,
                    "Не удалось загрузить информацию об объектах",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override suspend fun onBottomSheetValue(sheetValue: SheetValue) {
        if (sheetValue == SheetValue.Hidden) {
            viewModel.onEvent(MapMainEvent.ObjectUnselected)
        }
    }

    @Composable
    override fun BoxScope.MapControlsContent() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .statusBarsPadding(),
            contentAlignment = Alignment.TopCenter
        ) {
            SearchTextField(
                text = "",
                onTextChanged = {},
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HackathonButton.M(
                onClick = {
                    viewModel.onEvent(MapMainEvent.AddNewObjectClicked)
                },
                text = "Добавить объект",
                modifier = Modifier.shadow(2.dp, shape = RoundedCornerShape(12.dp)),
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.staticWhite,
                    contentColor = HackathonTheme.colors.common.staticBlack,
                ),
                icon = HackathonButtonIcon(
                    resId = R.drawable.ic_add_icon_24dp,
                    sizeDp = 24,
                    tintColor = HackathonTheme.colors.icons.primary,
                ),
                shape = RoundedCornerShape(12.dp),
            )
        }
    }

    @Composable
    override fun ColumnScope.BottomSheetContent() {
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
        ObjectDetails(model = model)
    }

    //Plan details
    /*
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
                )
     */

    //Contract details
    /*
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
     */

    //Destinations
    /*
    data object ContractDetailsScreen : RootNavDestination("ContractDetailsScreen")
    data object ObjectDetailsScreen : RootNavDestination("ObjectDetailsScreen")

    data object PlanDetailsScreen : RootNavDestination("PlanDetailsScreen")
     */

    @Composable
    @MapboxMapComposable
    override fun MapboxMapScope.MapContent(cameraState: CameraState?) {
        val state by viewModel.state.collectAsStateWithLifecycle()
        val yellow = HackathonTheme.colors.elements.mapYellow
        val accent = HackathonTheme.colors.common.accent
        val darkGray = HackathonTheme.colors.elements.darkGray

        state.objectInfos.fastForEachIndexed { index, objectInfo ->
            val color = if (index == state.selectedObjectInfoIndex) accent else yellow

            objectInfo.zones.fastForEach { zone ->
                when (zone.renderMode) {
                    ZoneRenderMode.POLYLINE -> PolylineAnnotation(
                        points = zone.points,
                    ) {
                        lineColor = color
                        lineWidth = 5.0
                        lineBorderWidth = 1.0
                        lineBorderColor = darkGray
                    }

                    ZoneRenderMode.POLYGON -> PolygonAnnotation(
                        points = listOf(zone.points),
                    ) {
                        fillColor = color
                        fillOutlineColor = darkGray
                    }
                }
            }

            if ((cameraState?.zoom ?: 0.0) >= 15.0) {
                ViewAnnotation(
                    options = viewAnnotationOptions {
                        geometry(objectInfo.viewPoint)
                    },
                ) {
                    if (objectInfo.planProgressions.isNotEmpty()) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            objectInfo.planProgressions.fastForEach { progress ->
                                ObjectMarker(progress = progress, modifier = Modifier.clickable {
                                    viewModel.onEvent(
                                        MapMainEvent.ObjectClicked(index)
                                    )
                                })
                            }
                        }
                    } else {
                        ObjectMarkerPlaceholder(modifier = Modifier.clickable {
                            viewModel.onEvent(
                                MapMainEvent.ObjectClicked(index)
                            )
                        })
                    }
                }
            }
        }
    }
}