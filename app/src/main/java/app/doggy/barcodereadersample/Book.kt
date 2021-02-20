package app.doggy.barcodereadersample

import com.google.gson.annotations.SerializedName

data class Book(
    val id: String,
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfo
)