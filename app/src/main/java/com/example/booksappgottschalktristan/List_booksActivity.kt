package com.example.booksappgottschalktristan

import ApiService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListBooksActivity : AppCompatActivity() {
private var booksListNode: RecyclerView = findViewById(R.id.books_list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_books)

        // Layout Manager
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        booksListNode.layoutManager = layoutManager
        // Adapter
        val bookAdapter = BookAdapter() // API : https://db.ygoprodeck.com/api/v7/cardinfo.php?banlist=ocg&has_effect=false
        booksListNode.adapter = bookAdapter

        // TODO : Appeler ici l'aPI , après reception
        /*val response = try {
            val data = retrofit2.http.GET()
        }
        bookAdapter.listBooks = listOf()
        bookAdapter.notifyDataSetChanged()*/
    }

    object RetrofitInstance {
        private const val BASE_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php?"

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val apiService: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }
    }

}