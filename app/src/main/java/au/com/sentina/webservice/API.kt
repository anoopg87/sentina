package au.com.sentina.webservice

import au.com.sentina.data.Properties
import io.reactivex.Single
import retrofit2.http.GET


interface API {
    @GET("/test/properties")
    fun getProperties(): Single<Properties>
}