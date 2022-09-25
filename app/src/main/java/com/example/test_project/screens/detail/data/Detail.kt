package com.example.test_project.screens.detail.data

import com.google.gson.annotations.SerializedName

data class Detail (
	@SerializedName("success") val success : Boolean,
	@SerializedName("error") val error : String,
	@SerializedName("time") val time : String,
	@SerializedName("data") val data : Data
) {
	data class Data (
		@SerializedName("id") val id : Int,
		@SerializedName("url") val url : String,
		@SerializedName("image") val image : Image,
		@SerializedName("title") val title : String,
		@SerializedName("subtitle") val subtitle : String,
		@SerializedName("like") val like : Int,
		@SerializedName("date") val date : String,
		@SerializedName("content") val content : String
	) {
		data class Image (
			@SerializedName("sm") val sm : String,
			@SerializedName("md") val md : String,
			@SerializedName("lg") val lg : String
		)
	}
}