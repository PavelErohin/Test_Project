package com.example.test_project.screens.main.data

import com.google.gson.annotations.SerializedName

data class Blog (
	@SerializedName("success") val success : Boolean,
	@SerializedName("error") val error : String,
	@SerializedName("time") val time : String,
	@SerializedName("data") val data : List<Data>
) {
	data class Data (
		@SerializedName("id") val id : Int,
		@SerializedName("image") val image : Image,
		@SerializedName("title") val title : String,
		@SerializedName("subtitle") val subtitle : String,
		@SerializedName("view") val view : Int,
		@SerializedName("like") val like : Int,
		@SerializedName("date") val date : Date
	) {
		data class Date (
			@SerializedName("typeDate") val typeDate : String,
			@SerializedName("date") val date : String
		)

		data class Image (
			@SerializedName("sm") val sm : String,
			@SerializedName("md") val md : String,
			@SerializedName("lg") val lg : String
		)
	}
}