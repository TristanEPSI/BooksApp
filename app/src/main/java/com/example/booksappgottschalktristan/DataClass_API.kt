import retrofit2.http.GET

interface ApiService {
    @GET("banlist=ocg&has_effect=false")
    suspend fun getData(): List<Card>
}



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
    val ygoprodeckUrl: String,
    val cardSets: List<CardSet>,
    val banlistInfo: BanlistInfo,
    val cardImages: List<CardImage>,
    val cardPrices: List<CardPrice>
)

data class CardSet(
    val setName: String,
    val setCode: String,
    val setRarity: String,
    val setRarityCode: String,
    val setPrice: String
)

data class BanlistInfo(
    val banTcg: String,
    val banOcg: String
)

data class CardImage(
    val id: Int,
    val imageUrl: String,
    val imageUrlSmall: String,
    val imageUrlCropped: String
)

data class CardPrice(
    val cardmarketPrice: String,
    val tcgplayerPrice: String,
    val ebayPrice: String,
    val amazonPrice: String,
    val coolstuffincPrice: String
)
