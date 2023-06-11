package com.dicoding.ternakku.data.retrofit.response

import com.google.gson.annotations.SerializedName

data class ListDiseaseResponse(
    @field:SerializedName("diseases")
    val diseases: List<DiseasesItem>
)

data class DiseasesItem(
    @field:SerializedName("disease_details")
    val diseaseDetails: String,

    @field:SerializedName("handling_method")
    val handlingMethod: String,

    @field:SerializedName("disease_name")
    val diseaseName: String,

    @field:SerializedName("id")
    val id: Int
)