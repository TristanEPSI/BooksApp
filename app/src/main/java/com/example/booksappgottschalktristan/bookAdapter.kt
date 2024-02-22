package com.example.booksappgottschalktristan

import Card
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BookAdapter : RecyclerView.Adapter<BookViewHolder>() {
    var listCards = listOf<Card>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BookViewHolder {
        val context = viewGroup.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.book_in_list, viewGroup, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = listCards[position]
        holder.updateBooksList(book)
    }

    override fun getItemCount(): Int = listCards.size
}