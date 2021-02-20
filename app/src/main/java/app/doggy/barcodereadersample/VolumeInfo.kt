package app.doggy.barcodereadersample

import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    @SerializedName("description") val content: String
)