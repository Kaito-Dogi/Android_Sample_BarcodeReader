package app.doggy.barcodereadersample

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("totalItems") val totalItems: Int,
    val items: List<Item>
)