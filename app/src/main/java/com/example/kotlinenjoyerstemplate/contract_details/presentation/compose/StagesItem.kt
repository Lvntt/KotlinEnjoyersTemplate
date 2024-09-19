package com.example.kotlinenjoyerstemplate.contract_details.presentation.compose

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.common.StatusWorkEnum
import com.example.kotlinenjoyerstemplate.contract_details.presentation.model.ContractDetailsItem
import com.example.kotlinenjoyerstemplate.ui.common.FrameRounded
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import java.util.UUID

@Composable
fun StagesItem(
    model: ContractDetailsItem.Stages,
    onStageButtonClick: (ContractDetailsItem.Stages.Stage) -> Unit,
    modifier: Modifier = Modifier,
) = FrameRounded(
    modifier = modifier,
    sidePadding = PaddingValues(0.dp)
) {
    val context = LocalContext.current

    model.chosenStage?.let {
        Column {
            LazyRow(
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 12.dp,
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(model.stages) { stage ->
                    StageButton(
                        model = stage,
                        isChosen = model.chosenStage == stage,
                        onClick = onStageButtonClick,
                    )
                }
            }
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                HackathonBlock(
                    mainPart = HackathonBlockMainPart(
                        title = HackathonBlockMainPart.Text(
                            text = model.chosenStage.subExecutorName,
                        ),
                        subtitle = HackathonBlockMainPart.Text(
                            text = "Субподрядчик",
                        ),
                    ),
                    leftPart = HackathonBlockLeftPart.Icon(
                        source = ImageSource.FromResource(
                            resId = R.drawable.ic_build_24dp,
                            contentDescription = null,
                            tint = HackathonTheme.colors.icons.secondary,
                        ),
                        sizeDp = 24,
                    ),
                    innerPadding = PaddingValues(vertical = 12.dp),
                )
                HackathonBlock(
                    mainPart = HackathonBlockMainPart(
                        title = HackathonBlockMainPart.Text(
                            text = model.chosenStage.subExecutorPhone,
                        ),
                        subtitle = HackathonBlockMainPart.Text(
                            text = "Телефон субподрядчика",
                        ),
                    ),
                    leftPart = HackathonBlockLeftPart.Icon(
                        source = ImageSource.FromResource(
                            resId = R.drawable.ic_call_24dp,
                            contentDescription = null,
                            tint = HackathonTheme.colors.icons.secondary,
                        ),
                        sizeDp = 24,
                    ),
                    innerPadding = PaddingValues(vertical = 12.dp),
                )
                HackathonBlock(
                    mainPart = HackathonBlockMainPart(
                        title = HackathonBlockMainPart.Text(
                            text = model.chosenStage.subExecutorAddress,
                        ),
                        subtitle = HackathonBlockMainPart.Text(
                            text = "Адрес субподрядчика",
                        ),
                    ),
                    leftPart = HackathonBlockLeftPart.Icon(
                        source = ImageSource.FromResource(
                            resId = R.drawable.ic_home_fill_24dp,
                            contentDescription = null,
                            tint = HackathonTheme.colors.icons.secondary,
                        ),
                        sizeDp = 24,
                    ),
                    innerPadding = PaddingValues(vertical = 12.dp),
                )
                HackathonBlock(
                    mainPart = HackathonBlockMainPart(
                        title = HackathonBlockMainPart.Text(
                            text = model.chosenStage.plannedStartDate,
                        ),
                        subtitle = HackathonBlockMainPart.Text(
                            text = "Начало работ, запланированное",
                        ),
                    ),
                    leftPart = HackathonBlockLeftPart.Icon(
                        source = ImageSource.FromResource(
                            resId = R.drawable.ic_event_24dp,
                            contentDescription = null,
                            tint = HackathonTheme.colors.icons.secondary,
                        ),
                        sizeDp = 24,
                    ),
                    innerPadding = PaddingValues(vertical = 12.dp),
                )
                HackathonBlock(
                    mainPart = HackathonBlockMainPart(
                        title = HackathonBlockMainPart.Text(
                            text = model.chosenStage.actualStartDate,
                        ),
                        subtitle = HackathonBlockMainPart.Text(
                            text = "Начало работ, фактическое",
                        ),
                    ),
                    leftPart = HackathonBlockLeftPart.Icon(
                        source = ImageSource.FromResource(
                            resId = R.drawable.ic_event_24dp,
                            contentDescription = null,
                            tint = HackathonTheme.colors.icons.secondary,
                        ),
                        sizeDp = 24,
                    ),
                    innerPadding = PaddingValues(vertical = 12.dp),
                )
                HackathonBlock(
                    mainPart = HackathonBlockMainPart(
                        title = HackathonBlockMainPart.Text(
                            text = model.chosenStage.plannedEndDate,
                        ),
                        subtitle = HackathonBlockMainPart.Text(
                            text = "Окончание работ, запланированное",
                        ),
                    ),
                    leftPart = HackathonBlockLeftPart.Icon(
                        source = ImageSource.FromResource(
                            resId = R.drawable.ic_event_available_24dp,
                            contentDescription = null,
                            tint = HackathonTheme.colors.icons.secondary,
                        ),
                        sizeDp = 24,
                    ),
                    innerPadding = PaddingValues(vertical = 12.dp),
                )
                HackathonBlock(
                    mainPart = HackathonBlockMainPart(
                        title = HackathonBlockMainPart.Text(
                            text = model.chosenStage.actualEndDate,
                        ),
                        subtitle = HackathonBlockMainPart.Text(
                            text = "Окончание работ, фактическое",
                        ),
                    ),
                    leftPart = HackathonBlockLeftPart.Icon(
                        source = ImageSource.FromResource(
                            resId = R.drawable.ic_event_available_24dp,
                            contentDescription = null,
                            tint = HackathonTheme.colors.icons.secondary,
                        ),
                        sizeDp = 24,
                    ),
                    innerPadding = PaddingValues(vertical = 12.dp),
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 1.dp,
                color = HackathonTheme.colors.elements.lightGray,
            )
            Spacer(modifier = Modifier.height(8.dp))
            model.chosenStage.documents.forEach { document ->
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_description_24dp),
                        contentDescription = null,
                        tint = HackathonTheme.colors.icons.primary,
                    )
                    Text(
                        modifier = Modifier.clickable {
                            val fileName = "${UUID.randomUUID()}.${document.extension}"
                            tryDownloadDocument(
                                url = document.url,
                                context = context,
                                fileName = fileName,
                            )
                        },
                        text = document.title,
                        color = HackathonTheme.colors.elements.link,
                        style = HackathonTheme.typography.texts.textM,
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }

}

@Composable
private fun StageButton(
    model: ContractDetailsItem.Stages.Stage,
    isChosen: Boolean,
    onClick: (ContractDetailsItem.Stages.Stage) -> Unit,
    modifier: Modifier = Modifier,
) {
    val buttonColor = if (isChosen) {
        HackathonTheme.colors.common.accent
    } else {
        HackathonTheme.colors.background.grey
    }
    val nameColor = if (isChosen) {
        HackathonTheme.colors.common.staticWhite
    } else {
        HackathonTheme.colors.text.primary.default
    }
    val statusColor = if (isChosen) {
        HackathonTheme.colors.common.staticWhite
    } else {
        HackathonTheme.colors.text.secondary.default
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(buttonColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(),
                onClick = {
                    onClick(model)
                },
            )
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Text(
            text = model.name,
            style = HackathonTheme.typography.texts.textL,
            color = nameColor,
        )
        Text(
            text = model.status.text,
            style = HackathonTheme.typography.texts.textS,
            color = statusColor,
        )
    }
}

fun tryDownloadDocument(url: String, context: Context, fileName: String) {
    try {
        val request = DownloadManager.Request(Uri.parse(url))
            .setTitle(fileName)
            .setDescription("Downloading file...")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED) // Показать уведомление после завершения
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName) // Указание, куда сохранить файл

        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadManager.enqueue(request)

        Toast.makeText(context, "Файл скачивается...", Toast.LENGTH_SHORT).show()
    } catch (_: Exception) { /* nothing */ }
}

@Preview
@Composable
private fun StagesItemPreview() = HackathonTheme {
    val stages = listOf(
        ContractDetailsItem.Stages.Stage(
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
                ContractDetailsItem.Stages.Document(
                    title = "Паспорт объекта",
                    url = "",
                    extension = "",
                ),
                ContractDetailsItem.Stages.Document(
                    title = "Фото объекта",
                    url = "",
                    extension = "",
                ),
            ),
        ),
        ContractDetailsItem.Stages.Stage(
            name = "Название второго этапа",
            status = StatusWorkEnum.IN_PROCESS,
            plannedStartDate = "15 сентября 2024",
            plannedEndDate = "15 сентября 2024",
            actualStartDate = "15 сентября 2024",
            actualEndDate = "15 сентября 2024",
            subExecutorName = "ООО «Спектр»",
            subExecutorPhone = "+7 (934) 587-65-09",
            subExecutorAddress = "г. Москва, ул. Пушкина, д.1 к. 69",
            documents = listOf(
                ContractDetailsItem.Stages.Document(
                    title = "Название документа",
                    url = "",
                    extension = "",
                ),
                ContractDetailsItem.Stages.Document(
                    title = "Другое название документа",
                    url = "",
                    extension = "",
                ),
            ),
        ),
        ContractDetailsItem.Stages.Stage(
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
                ContractDetailsItem.Stages.Document(
                    title = "Паспорт объекта",
                    url = "",
                    extension = "",
                ),
                ContractDetailsItem.Stages.Document(
                    title = "Фото объекта",
                    url = "",
                    extension = "",
                ),
            ),
        ),
    )
    var chosenStage by remember { mutableStateOf(stages[0]) }
    val model = ContractDetailsItem.Stages(
        stages = stages,
        chosenStage = chosenStage,
    )
    StagesItem(
        model = model,
        onStageButtonClick = {}
    )
}
