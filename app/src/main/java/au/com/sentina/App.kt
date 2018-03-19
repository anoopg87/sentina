package au.com.sentina

import android.app.Application
import au.com.sentina.di.WebServiceModule
import au.com.sentina.util.Constants
import com.app.kotlin.di.*

class App:Application() {
    var context: App?=null

    override fun onCreate() {
        super.onCreate()
        context=this
        appComponent=createAppComponent()
        appComponent?.inject(this)
    }

    private fun createAppComponent(): AppComponent? {
        return DaggerAppComponent.builder().appModule(context?.let { AppModule(it) })
                .okHttpModule(OkHttpModule())
                .retrofitModule(RetrofitModule(Constants.MAIN_API_URL))
                .webServiceModule(WebServiceModule()).build()
    }

    companion object {
        var appComponent:AppComponent?=null
    }
}