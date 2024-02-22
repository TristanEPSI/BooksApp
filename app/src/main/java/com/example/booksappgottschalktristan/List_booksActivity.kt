package com.example.booksappgottschalktristan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        val cardAdapter = CardAdapter()
        booksListNode.adapter = cardAdapter

        // TODO : Appeler ici l'aPI , après reception
        val service = RetrofitInstance.apiService
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.getData()
                withContext(Dispatchers.Main){
                    cardAdapter.listCards = response
                    cardAdapter.notifyDataSetChanged()
                }
            } catch (e:Exception) {
                Log.e("Error", "Error: $e")
            }
        }
    }
}