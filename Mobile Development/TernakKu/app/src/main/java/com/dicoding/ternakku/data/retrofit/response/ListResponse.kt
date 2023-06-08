package com.dicoding.ternakku.data.retrofit.response

import com.google.gson.annotations.SerializedName

data class ListResponse(

	@field:SerializedName("ListResponse")
	val listResponse: List<ListResponseItem>
)

data class ListResponseItem(

	@field:SerializedName("disease_details")
	val diseaseDetails: String,

	@field:SerializedName("handling_method")
	val handlingMethod: String,

	@field:SerializedName("disease_name")
	val diseaseName: String
)
