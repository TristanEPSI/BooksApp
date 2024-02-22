package com.example.booksappgottschalktristan

import Card
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun updateBooksList (card: Card) {
        val cardNode = itemView.findViewById<TextView>(R.id.bookInListName)
        cardNode.text = card.name
    }

}