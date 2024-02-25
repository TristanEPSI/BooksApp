package com.example.booksappgottschalktristan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailsCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_book)
        val cardNameNode = findViewById<TextView>(R.id.detailsCardTitle)
        val cardDescNode = findViewById<TextView>(R.id.detailsCardDesc)
        val cardAtkNode = findViewById<TextView>(R.id.detailsCardAtk)
        val cardDefNode = findViewById<TextView>(R.id.detailsCardDef)
        val cardIDNode = findViewById<TextView>(R.id.detailsCardID)
        val cardPriceNode = findViewById<TextView>(R.id.detailsCardPrice)
        val cardImageNode = findViewById<ImageView>(R.id.detailsCardImage)
        val cardDetails = getAllIntentVal()
        val cardAtkNodetext = "ATK: ${cardDetails?.atk}"
        val cardDefNodetext = "ATK: ${cardDetails?.def}"
        val cardIdNodetext = "ID: ${cardDetails?.ID}"
        val cardPriceNodetext = "Price (amazon): ${cardDetails?.Price}"
        cardNameNode.text = cardDetails?.name
        cardDescNode.text =  cardDetails?.desc
        cardAtkNode.text = cardAtkNodetext
        cardDefNode.text = cardDefNodetext
        cardIDNode.text = cardIdNodetext
        cardPriceNode.text = cardPriceNodetext
        Picasso.get().load(cardDetails?.URL).into(cardImageNode)
    }
    private fun getAllIntentVal(): CardDetails? {
        val intent = intent
        val cardName = intent.getStringExtra("CardName")
        val cardDesc = intent.getStringExtra("CardDesc")
        val cardURL = intent.getStringExtra("CardURL")
        val cardAtk = intent.getIntExtra("CardAtk",0).toString()
        val cardDef = intent.getIntExtra("CardDef",0).toString()
        val cardID = intent.getIntExtra("CardID",0).toString()
        val cardPrice = intent.getStringExtra("CardPrice")
        val card = cardName?.let { CardDetails(cardName, cardDesc, cardAtk, cardDef, cardURL, cardID, cardPrice) }
        return card


    }
    fun goToListBook(view: View) {
        val intent = Intent(this, ListBooksActivity::class.java)
        startActivity(intent)
    }
class CardDetails (
    val name: String ? = "Name not found",
    val desc: String ? = "Desc not found",
    val atk: String ? = "",
    val def: String ? = "",
    val URL: String ? = "URL does not exist",
    val ID: String ? = "",
    val Price: String ? = "Price error",
)




}