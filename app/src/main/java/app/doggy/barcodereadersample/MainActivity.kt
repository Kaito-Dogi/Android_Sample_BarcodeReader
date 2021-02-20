package app.doggy.barcodereadersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.api.load
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //RetrofitとGSONを組み合わせて通信の準備をする。
        val gson: Gson =
            GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val bookService: BookService = retrofit.create(BookService::class.java)

        requestButton.setOnClickListener {

            //runBlocking内
            runBlocking(Dispatchers.IO) {
                runCatching {
                    bookService.getBook("isbn:" + isbnEditText.text.toString())
                }
            }.onSuccess {
                //bookImageView.load(it.avatarUrl)
                titleTextView.text = it.items[0].volumeInfo.title
                authorTextView.text = it.items[0].volumeInfo.authors[0]
                descriptionTextView.text = it.items[0].volumeInfo.content
                Toast.makeText(applicationContext, "成功", Toast.LENGTH_SHORT).show()
            }.onFailure {
                Toast.makeText(applicationContext, "失敗", Toast.LENGTH_SHORT).show()
            }

        }

        floatingActionButton.setOnClickListener {

        }
    }
}