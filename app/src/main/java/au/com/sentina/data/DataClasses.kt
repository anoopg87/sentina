package au.com.sentina.data

 class Properties(val data: List<Data>)

 data class Data(
        val id: Int,
        val is_premium: Boolean,
        val state: String,
        val title: String,
        val bedrooms: Int,
        val bathrooms: Int,
        val carspots:Int,
        val description:String,
        val price: Double,
        val owner: Owner,
        val location: Location,
        val photo: Photo)


data class Owner(val id:Int,
                 val first_name: String,
                 val last_name:String,
                 val email:String,
                val avatar: Avatar
                 )
data class ImageUrl(val url:String)

 data class Avatar(val url: String,
                  val small:ImageUrl,
                  val medium:ImageUrl,
                  val large:ImageUrl,
                  val profile:ImageUrl)

 data class Location(val id: Int,
                    val address_1:String,
                    val address_2:String,
                    val suburb:String,
                    val state:String,
                    val postcode:String,
                    val country:String,
                    val latitude:Double,
                    val longitude:Double,
                    val full_address:String)

 data class Photo(val id: Int,
                 val default:Boolean,
                 val image: Image
                 )

 data class Image(val url:String,
                 val small: ImageUrl,
                 val medium: ImageUrl,
                 val large: ImageUrl)