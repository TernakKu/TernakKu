package com.dicoding.ternakku.data.retrofit.response

import com.google.gson.annotations.SerializedName

data class HistoryResponse(

	@field:SerializedName("history")
	val history: List<HistoryItem>
)

data class HistoryItem(

	@field:SerializedName("disease_details")
	val diseaseDetails: String,

	@field:SerializedName("handling_method")
	val handlingMethod: String,

	@field:SerializedName("disease_name")
	val diseaseName: String,

	@field:SerializedName("timestamp")
	val timestamp: String
)
