package com.dicoding.ternakku.data.retrofit.response

import com.google.gson.annotations.SerializedName

data class HistoryNewResponse(

	@field:SerializedName("History Predict")
	val historyPredict: List<HistoryPredictItem>
)

data class HistoryPredictItem(

	@field:SerializedName("disease_details")
	val diseaseDetails: String,

	@field:SerializedName("handling_method")
	val handlingMethod: String,

	@field:SerializedName("disease_name")
	val diseaseName: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("timestamp")
	val timestamp: String
)
