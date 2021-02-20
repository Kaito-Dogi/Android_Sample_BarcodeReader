package app.doggy.barcodereadersample

import com.google.gson.annotations.SerializedName

data class Book(
    val volumeInfo: VolumeInfo,
    val id: String
    //@SerializedName("volumeInfo") val title: String,
    //@SerializedName("authors") val author: String,
    //@SerializedName("volumeInfo.description") val content: String
)