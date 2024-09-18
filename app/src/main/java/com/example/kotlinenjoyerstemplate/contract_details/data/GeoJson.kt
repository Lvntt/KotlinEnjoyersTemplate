package com.example.kotlinenjoyerstemplate.contract_details.data

data class GeoJson(
    val type: String,
    val feature: List<GeoJsonFeature>,
)

data class GeoJsonFeature(
    val type: String,
    val geometry: List<GeoJsonGeometry>,
    val properties: GeoJsonProperties,
)

data class GeoJsonGeometry(
    val type: String,
    val coordinates: List<Float>,
)

data class GeoJsonProperties(
    val additionalProp1: String,
    val additionalProp2: String,
    val additionalProp3: String,
)
