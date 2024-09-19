package com.example.kotlinenjoyerstemplate.company_list.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.contract_details.presentation.compose.tryDownloadDocument
import com.example.kotlinenjoyerstemplate.ui.common.FrameRounded
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.alert_dialog.HackathonAlertDialog
import com.example.kotlinenjoyerstemplate.ui.components.alert_dialog.model.HackathonAlertDialogButton
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.header_block.HackathonHeaderBlock
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import java.util.UUID

@Composable
fun CompanyItem(
    companyName: String,
    companyPhone: String,
    companyAddress: String,
    dialogTitle: String,
    dialogDescription: String,
    pdfUrl: String,
) {
    val context = LocalContext.current

    var isOpenDialog by remember { mutableStateOf(false) }

    if (isOpenDialog) {
        HackathonAlertDialog(
            title = dialogTitle,
            description = dialogDescription,
            confirmButton = HackathonAlertDialogButton(
                text = "OK",
                onClick = { isOpenDialog = false },
            ),
            onDismissRequest = { isOpenDialog = false }
        )
    }

    Column {
        HackathonHeaderBlock(
            mainPart = HackathonHeaderBlockMainPart(
                title = HackathonHeaderBlockMainPart.Text(
                    text = companyName,
                )
            ),
            sidePadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 12.dp,
            ),
            backgroundColor = HackathonTheme.colors.background.grey,
        )
        FrameRounded {
            Column {
                HackathonBlock(
                    mainPart = HackathonBlockMainPart(
                        title = HackathonBlockMainPart.Text(
                            text = companyPhone,
                        ),
                        subtitle = HackathonBlockMainPart.Text(
                            text = "Телефон",
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
                            text = companyAddress,
                        ),
                        subtitle = HackathonBlockMainPart.Text(
                            text = "Адрес",
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
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(
                    thickness = 1.dp,
                    color = HackathonTheme.colors.elements.lightGray,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_bolt_24dp),
                        contentDescription = null,
                        tint = HackathonTheme.colors.icons.secondary,
                    )
                    Text(
                        modifier = Modifier.clickable {
                            isOpenDialog = true
                        },
                        text = "Краткий отчет от ИИ",
                        color = HackathonTheme.colors.elements.link,
                        style = HackathonTheme.typography.texts.textM,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_description_24dp),
                        contentDescription = null,
                        tint = HackathonTheme.colors.icons.secondary,
                    )
                    Text(
                        modifier = Modifier.clickable {
                            val fileName = "${UUID.randomUUID()}.pdf"
                            tryDownloadDocument(
                                url = pdfUrl,
                                context = context,
                                fileName = fileName,
                            )
                        },
                        text = "Полный отчет",
                        color = HackathonTheme.colors.elements.link,
                        style = HackathonTheme.typography.texts.textM,
                    )
                }
            }
        }
    }
}