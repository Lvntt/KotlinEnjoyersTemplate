package com.example.kotlinenjoyerstemplate.core.data

class ObjectRepository(
    private val apiService: ObjectApiService,
) {

    suspend fun getObjectDetails(objectId: Long, isMock: Boolean = false): ObjectView = if (isMock) {
        MockObjectData.objectView
    } else {
        apiService.getObjectDetails(objectId)
    }

    suspend fun getPlanDetails(planId: Long, isMock: Boolean = false): ObjectPlanView = if (isMock) {
        MockObjectData.objectPlanView
    } else {
        apiService.getPlanDetails(planId)
    }

    suspend fun getContractDetails(contractId: Long, isMock: Boolean = false): ObjectContractView = if (isMock) {
        MockObjectData.objectContractView
    } else {
        apiService.getContractDetails(contractId)
    }
}

object MockObjectData {

    val objectView = ObjectView(
        `object` = ObjectShortInfoView(
            objectId = 3204265,
            name = "ул. Комарова - ул. Белобородова",
            address = "МО, г. Мытищи"
        ),
        plans = listOf(
            PlanShortInfoView(
                status = "CANCELED",
                planId = 4107166,
                planName = "Плановый ремонт дороги",
                description = "Ежегодный ремонт 2024",
            ),
            PlanShortInfoView(
                status = "IN_PROCESS",
                planId = 1260391,
                planName = "Срочный ремонт дороги",
                description = "Ежегодный ремонт 2024",
            ),
            PlanShortInfoView(
                status = "COMPLETED",
                planId = 7159284,
                planName = "Плановый ремонт дороги",
                description = "Ежегодный ремонт 2025",
            ),
            PlanShortInfoView(
                status = "PLANNED",
                planId = 8489363,
                planName = "Плановый ремонт дороги",
                description = "Ежегодный ремонт 2026",
            ),
        )
    )

    val objectPlanView = ObjectPlanView(
        `object` = ObjectShortInfoView(
            objectId = 3204265,
            name = "ул. Комарова - ул. Белобородова",
            address = "МО, г. Мытищи"
        ),
        plan = PlanShortInfoView(
            status = "CANCELED",
            planId = 4107166,
            planName = "Плановый ремонт дороги",
            description = "Ежегодный ремонт 2024",
        ),
        percentageComplete = 75,
        firstPlannedStartDate = "2024-09-18",
        contracts = listOf(
            ContractShortInfoView(
                contractId = 7440404,
                executorName = "ООО «Спектр»",
                contractName = "Устройство транспортной развязки"
            ),
            ContractShortInfoView(
                contractId = 7440405,
                executorName = "ООО «Хорошие Дороги»",
                contractName = "Устройство транспортной развязки"
            ),
        )
    )

    val objectContractView = ObjectContractView(
        `object` = ObjectShortInfoView(
            objectId = 3204265,
            name = "ул. Комарова - ул. Белобородова",
            address = "МО, г. Мытищи"
        ),
        contract = ContractView(
            name = "Устройство транспортной развязки",
            budget = 300000,
            plannedEndDate = "2019-10-01",
            plannedStartDate = "2019-07-10",
            warrantyEndDate = "2019-10-01",
            nameCustomer = "Муниципальное казенное учреждение «УКС ЖКХ»",
            phoneCustomer = "+7 (912) 680-00-50",
            nameGeneralExecutor = "ООО «Спектр»",
            phoneGeneralExecutor = "+7 (934) 587-65-09",
            generalExecutorOrganization = Organization(
                organizationId = 0,
                name = "ООО «Спектр»",
                phone = "+7 (934) 587-65-09",
                address = "г. Москва, ул. Пушкина, д. 1 к. 69",
            ),
            customerOrganization = Organization(
                organizationId = 0,
                name = "Муниципальное казенное учреждение «УКС ЖКХ»",
                phone = "+7 (912) 680-00-50",
                address = "г. Москва, ул. Пушкина, д.2 к. 69",
            ),
            stages = listOf(
                ObjectStageModel(
                    subExecutorOrganization = Organization(
                        organizationId = 0,
                        name = "ООО «Спектр»",
                        phone = "+7 (934) 587-65-09",
                        address = "г. Москва, ул. Пушкина, д. 1 к. 69",
                    ),
                    name = "Планирование",
                    plannedEndDate = "2019-10-01",
                    plannedStartDate = "2019-07-10",
                    status = "COMPLETED",
                    documents = listOf(
                        ObjectStageDocumentModel(
                            documentId = 0,
                            name = "Паспорт объекта",
                            downloadUrl = "https://storage.yandexcloud.net/hackathon-its/Reliability.docx?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=YCAJEPpK5UVZoEUcVh9UgRy79/20240918/ru-central1/s3/aws4_request&X-Amz-Date=20240918T085204Z&X-Amz-Expires=223200&X-Amz-Signature=ADE2164BBC96818C6080302CB37E1CCF6B7343C93184BD80CE86A00FF194C33C&X-Amz-SignedHeaders=host",
                            format = "docx",
                        ),
                        ObjectStageDocumentModel(
                            documentId = 0,
                            name = "Фото объекта",
                            downloadUrl = "https://storage.yandexcloud.net/hackathon-its/Reliability.docx?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=YCAJEPpK5UVZoEUcVh9UgRy79/20240918/ru-central1/s3/aws4_request&X-Amz-Date=20240918T085204Z&X-Amz-Expires=223200&X-Amz-Signature=ADE2164BBC96818C6080302CB37E1CCF6B7343C93184BD80CE86A00FF194C33C&X-Amz-SignedHeaders=host",
                            format = "docx",
                        ),
                    ),
                    actualEndDate = "2019-10-01",
                    actualStartDate = "2019-07-17",
                ),
                ObjectStageModel(
                    subExecutorOrganization = Organization(
                        organizationId = 0,
                        name = "ООО «Спектр»",
                        phone = "+7 (934) 587-65-09",
                        address = "г. Москва, ул. Пушкина, д. 1 к. 69",
                    ),
                    name = "Дорожные работы",
                    plannedEndDate = "2019-11-02",
                    plannedStartDate = "2019-08-11",
                    status = "COMPLETED",
                    documents = listOf(
                        ObjectStageDocumentModel(
                            documentId = 0,
                            name = "Фото 1",
                            downloadUrl = "https://storage.yandexcloud.net/hackathon-its/Reliability.docx?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=YCAJEPpK5UVZoEUcVh9UgRy79/20240918/ru-central1/s3/aws4_request&X-Amz-Date=20240918T085204Z&X-Amz-Expires=223200&X-Amz-Signature=ADE2164BBC96818C6080302CB37E1CCF6B7343C93184BD80CE86A00FF194C33C&X-Amz-SignedHeaders=host",
                            format = "docx",
                        ),
                        ObjectStageDocumentModel(
                            documentId = 0,
                            name = "Фото 2",
                            downloadUrl = "https://storage.yandexcloud.net/hackathon-its/Reliability.docx?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=YCAJEPpK5UVZoEUcVh9UgRy79/20240918/ru-central1/s3/aws4_request&X-Amz-Date=20240918T085204Z&X-Amz-Expires=223200&X-Amz-Signature=ADE2164BBC96818C6080302CB37E1CCF6B7343C93184BD80CE86A00FF194C33C&X-Amz-SignedHeaders=host",
                            format = "docx",
                        ),
                    ),
                    actualEndDate = "2019-11-02",
                    actualStartDate = "2019-08-11",
                )
            )
        )
    )
}
