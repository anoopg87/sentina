package au.com.sentina.di

import android.content.Context
import com.app.kotlin.di.AppScope
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class PicassoModule {
    @Provides
    @AppScope
    fun providePicasso(ctx:Context, okHttpClient: OkHttpClient):Picasso{
        return Picasso.Builder(ctx)
                .downloader(OkHttp3Downloader(okHttpClient))
                .build()
    }
}