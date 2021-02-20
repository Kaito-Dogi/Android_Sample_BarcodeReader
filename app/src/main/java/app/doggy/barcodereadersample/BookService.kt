package app.doggy.barcodereadersample

import retrofit2.http.GET
import retrofit2.http.Path

interface BookService {

    //@GET("volumes/{volumeId}")
    //suspend fun getBook(@Path("volumeId") volumeId: String): Book

    @GET("volumes?q=isbn:{isbn}")
    suspend fun getBook(@Path("isbn") isbn: String): Book

}