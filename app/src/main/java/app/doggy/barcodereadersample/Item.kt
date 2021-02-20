package app.doggy.barcodereadersample

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfo
)