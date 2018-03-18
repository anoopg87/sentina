package com.app.kotlin.di

import android.content.Context
import au.com.sentina.di.WebServiceModule
import au.com.sentina.webservice.APIImplementation
import dagger.Component

@Component(modules = [(AppModule::class), (OkHttpModule::class), (RetrofitModule::class), (WebServiceModule::class)])
@AppScope
interface AppComponent {
    fun inject(ctx: Context)
    fun inject(apiImplementation: APIImplementation)
}