package au.com.sentina.webservice

import au.com.sentina.App
import au.com.sentina.data.Properties
import io.reactivex.Flowable
import javax.inject.Inject

class APIImplementation {
    var api: API?=null
    @Inject set

    init {
      App.appComponent?.inject(this)
    }

    fun getProperties():Flowable<Properties>?{

        return if(api!=null) {
            Flowable.fromCallable { api!!.getProperties().execute().body() }
        }else null

    }
}