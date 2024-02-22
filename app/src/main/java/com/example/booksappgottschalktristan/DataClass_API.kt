import com.fasterxml.jackson.annotation.JsonProperty
import retrofit2.http.GET
interface ApiService {
    @GET("cardinfo.php?banlist=ocg&has_effect=false")
    suspend fun getData(): CardsList
}

// JAkson properties Jackson COre

data class CardsList(
    val data: List<Card> = listOf()
)

data class Card(
    val id: Int,
    val name: String,
    val type: String,
    val frameType: String,
    val desc: String,
    val atk: Int,
    val def: Int,
    val level: Int,
    val race: String,
    val attribute: String,
    val archetype: String,
    val ygoprodeck_url: String,
    @JsonProperty("card_sets")
    val card_sets: List<CardSet>,
    @JsonProperty("banlist_info")
    val banlist_info: BanlistInfo,
    @JsonProperty("card_images")
    val card_images: List<CardImage>,
    @JsonProperty("card_images")
    val card_prices: List<CardPrice>,
)

data class CardSet(
    val set_name: String,
    val set_code: String,
    val set_rarity: String,
    val set_rarity_code: String,
    val set_price: String
)

data class BanlistInfo(
    val ban_tcg: String,
    val ban_ocg: String
)

data class CardImage(
    val id: Int,
    @JsonProperty("imageUrl")
    val image_url: String,
    @JsonProperty("image_url_small")
    val image_url_small: String,
    val image_url_cropped: String
)

data class CardPrice(
    val cardmarket_price: String,
    val tcgplayer_price: String,
    val ebay_price: String,
    val amazon_price: String,
    val coolstuffinc_price: String
)
