package com.example.booksappgottschalktristan

import Card
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private  val context : Context = itemView.context
    private val cardName = itemView.findViewById<TextView>(R.id.bookInListName)
    private val cardImage = itemView.findViewById<ImageView>(R.id.bookInListImage)
    private val cardDesc = itemView.findViewById<TextView>(R.id.bookInListDesc)
    fun updateBooksList (card: Card) {
        cardName.text = card.name
        cardDesc.text = card.desc
        Picasso.get().load(card.card_images[0].image_url).into(cardImage)

        itemView.setOnClickListener{
            val intent = Intent(context,DetailsCardActivity::class.java)
            intent.putExtra("CardName",card.name)
            intent.putExtra("CardDesc",card.desc)
            intent.putExtra("CardURL",card.card_images[0].image_url)
            intent.putExtra("CardAtk",card.atk)
            intent.putExtra("CardDef",card.def)
            intent.putExtra("CardID", card.id)
            intent.putExtra("CardPrice",card.card_prices[0].amazon_price)
            context.startActivity(intent)

        }
    }
}