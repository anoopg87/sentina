package au.com.sentina.repository

import au.com.sentina.App
import au.com.sentina.data.Properties
import au.com.sentina.webservice.API
import io.reactivex.Single
import javax.inject.Inject


class PropertyRepository {

    var api: API? = null
        @Inject set

    init {
        App.appComponent?.inject(this)
    }

    fun getProperties(): Single<Properties>? {
        return api?.getProperties()

    }
}