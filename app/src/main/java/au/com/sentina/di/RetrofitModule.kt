package com.app.kotlin.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by Whizz on 27/2/18.
 */
@Module
class RetrofitModule(private val apiUrl: String) {

    @Provides
    @AppScope
    fun rxJava2CallAdaptorFactory():RxJava2CallAdapterFactory= RxJava2CallAdapterFactory.create()

    @Provides
    @AppScope
    fun gson():Gson=GsonBuilder().create()

    @Provides
    @AppScope
    fun gsonConvertFactory(gson: Gson):GsonConverterFactory= GsonConverterFactory.create(gson)

    @Provides
    @AppScope
    fun retrofit(okHttpClient: OkHttpClient,gsonConverterFactory: GsonConverterFactory,rxJava2CallAdapterFactory: RxJava2CallAdapterFactory):Retrofit= with(Retrofit.Builder()){
        baseUrl(apiUrl)
        addConverterFactory(gsonConverterFactory)
        addCallAdapterFactory(rxJava2CallAdapterFactory)
        client(okHttpClient)
        build()
    }

}