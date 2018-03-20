package au.com.sentina.di

import android.content.Context
import com.app.kotlin.di.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient

@Module
class OkHttpModule {

    @Provides
    @AppScope
    fun okHttpClient(cache: Cache): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.cache(cache)
        return httpClient.build()
    }

    @Provides
    @AppScope
    fun cache(ctx: Context): Cache {
        val cacheSize: Long = 10 * 1024 * 1024
        return Cache(ctx.cacheDir, cacheSize)
    }

}