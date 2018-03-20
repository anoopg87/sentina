package au.com.sentina.di

import au.com.sentina.webservice.API
import com.app.kotlin.di.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class WebServiceModule {

    @Provides
    @AppScope
    fun provideAPI(retrofit: Retrofit): API {
        return retrofit.create(API::class.java)

    }
}