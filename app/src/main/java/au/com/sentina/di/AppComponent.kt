package au.com.sentina.di

import au.com.sentina.App
import au.com.sentina.repository.PropertyRepository
import com.app.kotlin.di.AppScope
import com.squareup.picasso.Picasso
import dagger.Component

@Component(modules = [(AppModule::class), (OkHttpModule::class), (PicassoModule::class), (RetrofitModule::class), (WebServiceModule::class)])
@AppScope
interface AppComponent {
    fun inject(ctx: App)
    fun inject(propertyRepository: PropertyRepository)
    fun picasso(): Picasso
}