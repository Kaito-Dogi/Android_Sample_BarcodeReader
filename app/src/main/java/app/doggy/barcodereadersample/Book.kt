package app.doggy.barcodereadersample

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("totalItems") val totalItems: Int,
    val items: List<Any>,
    //val id: String,
    //@SerializedName("volumeInfo") val volumeInfo: VolumeInfo
)