package au.com.sentina.di

import android.content.Context
import com.app.kotlin.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(private var ctx: Context) {

    @Provides
    @AppScope
    fun provideContext(): Context = this.ctx

}