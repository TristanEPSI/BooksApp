package com.example.booksappgottschalktristan

import Card
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun updateBooksList (card: Card) {
        val cardName = itemView.findViewById<TextView>(R.id.bookInListName)
        val cardImage = itemView.findViewById<ImageView>(R.id.bookInListImage)
        val cardDesc = itemView.findViewById<TextView>(R.id.bookInListDesc)
        cardName.text = card.name
        cardDesc.text = card.desc
        Picasso.get().load(card.card_images[0].image_url).into(cardImage)
    }
}