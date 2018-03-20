package au.com.sentina.webservice

import au.com.sentina.data.Properties
import retrofit2.Call
import retrofit2.http.GET


interface API {
    @GET("/test/properties")
    fun getProperties(): Call<Properties>
}