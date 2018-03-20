package au.com.sentina.webservice

import au.com.sentina.App
import au.com.sentina.data.Properties
import io.reactivex.Single
import javax.inject.Inject

class APIImplementation {
    var api: API? = null
        @Inject set

    init {
        App.appComponent?.inject(this)
    }

    fun getProperties(): Single<Properties>? {
        return if (api != null) {
            api!!.getProperties()
        } else null

    }
}