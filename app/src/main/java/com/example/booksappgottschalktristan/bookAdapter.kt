package com.example.booksappgottschalktristan

import Card
import CardsList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CardAdapter: RecyclerView.Adapter<BookViewHolder>() {
    lateinit var listCards: CardsList

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BookViewHolder {
        val context = viewGroup.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.book_in_list, viewGroup, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val card = listCards.data[position]
        holder.updateBooksList(card)
    }

    override fun getItemCount(): Int = listCards.data.size
}