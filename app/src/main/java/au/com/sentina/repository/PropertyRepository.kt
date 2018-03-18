package au.com.sentina.repository

import au.com.sentina.data.Properties
import au.com.sentina.webservice.APICallBacks
import au.com.sentina.webservice.APIImplementation
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PropertyRepository(private val callBack: APICallBacks<Properties>) {

    fun  getProperties(){
        val properties: Flowable<Properties>? = APIImplementation().getProperties()
            properties
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe(
                            {
                                callBack.setResult(it)
                            },
                            {
                                callBack.setError(it.localizedMessage)
                            })

    }
}