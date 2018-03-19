package com.app.kotlin.di

import au.com.sentina.App
import au.com.sentina.di.PicassoModule
import au.com.sentina.di.WebServiceModule
import au.com.sentina.webservice.APIImplementation
import com.squareup.picasso.Picasso
import dagger.Component

@Component(modules = [(AppModule::class), (OkHttpModule::class),(PicassoModule::class), (RetrofitModule::class), (WebServiceModule::class)])
@AppScope
interface AppComponent {
    fun inject(ctx: App)
    fun inject(apiImplementation: APIImplementation)
    fun picasso():Picasso
}