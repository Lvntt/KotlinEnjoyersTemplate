package com.example.kotlinenjoyerstemplate.contract_details.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.contract_details.presentation.model.ContractDetailsItem
import com.example.kotlinenjoyerstemplate.ui.common.FrameRounded
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun GeneralObjectInfoItem(
    model: ContractDetailsItem.GeneralInfoDetails,
    modifier: Modifier = Modifier
) = FrameRounded(modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = model.name,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Наименование объекта",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_id_card_24dp,
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
                    text = model.address,
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Адрес объекта",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_location_on_24dp,
                    contentDescription = null,
                    tint = HackathonTheme.colors.icons.secondary,
                ),
                sizeDp = 24,
            ),
            innerPadding = PaddingValues(vertical = 12.dp),
        )
    }
}

@Preview
@Composable
private fun GeneralInfoItemPreview() = HackathonTheme {
    GeneralObjectInfoItem(
        model = ContractDetailsItem.GeneralInfoDetails(
            name = "ул. Комарова - ул. Белобородова",
            address = "МО, г. Мытищи",
        )
    )
}
