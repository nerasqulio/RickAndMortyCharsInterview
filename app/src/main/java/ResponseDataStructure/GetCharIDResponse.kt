package ResponseDataStructure

import java.io.Serializable


data class GetCharIDResponse (
    val created: String,
    val episode: List<Any>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String


)   : Serializable{
    annotation class SerializedName(val value: String)
}



