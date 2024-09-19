package com.example.kotlinenjoyerstemplate.company_list.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun CompanyList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HackathonTheme.colors.background.grey)
            .verticalScroll(rememberScrollState()),
    ) {
        CompanyItem(
            companyName = "ООО «ДорогСтрой»",
            companyPhone = "+7 (934) 587-65-09",
            companyAddress = "г. Санкт-Петербург, ул. Ленина, д. 17",
            dialogTitle = "Подрядчик с сомнительной историей",
            dialogDescription = "Компания за последние полгода не выполнила четыре подрядных контракта, что свидетельствует о значительных нарушениях в управлении проектами и несоблюдении сроков.",
            pdfUrl = "https://storage.yandexcloud.net/hackathon-its/Kompania_nomer_2.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=YCAJEPpK5UVZoEUcVh9UgRy79/20240919/ru-central1/s3/aws4_request&X-Amz-Date=20240919T094534Z&X-Amz-Expires=252000&X-Amz-Signature=CDA82B88C30C490650DEFD0F0EED5B6558BA9E3F9EF687F272B1BABC2B66ED24&X-Amz-SignedHeaders=host"
        )
        Spacer(modifier = Modifier.height(12.dp))
        CompanyItem(
            companyName = "ООО «Дорожное строительство России»",
            companyPhone = "+7 (952) 839-06-57",
            companyAddress = "г. Москва, ул. Пушкина, д. 1 к. 69",
            dialogTitle = "Подрядчик с хорошей историей",
            dialogDescription = "За последние полгода компания допустила просрочку выполнения одного контракта, однако причиной задержки стали внешние обстоятельства, не зависящие от действий подрядчика.",
            pdfUrl = "https://storage.yandexcloud.net/hackathon-its/Kompania_nomer_1.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=YCAJEPpK5UVZoEUcVh9UgRy79/20240919/ru-central1/s3/aws4_request&X-Amz-Date=20240919T094508Z&X-Amz-Expires=252000&X-Amz-Signature=FE232F9C0B2F517F177D7A770704E99A872176582071F2523E5B943CDB408B48&X-Amz-SignedHeaders=host"
        )
    }
}

@Preview
@Composable
private fun CompanyListPreview() = HackathonTheme {
    CompanyList()
}