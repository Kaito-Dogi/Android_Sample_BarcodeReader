package app.doggy.barcodereadersample

import retrofit2.http.GET
import retrofit2.http.Path

interface BookService {

    @GET("books/v1/volumes/{volumeId}")
    suspend fun getBook(@Path("volumeId") volumeId: String): Book

}