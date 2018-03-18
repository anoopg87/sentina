package com.app.kotlin.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private var ctx: Context) {

  @Provides
  @AppScope
  fun provideContext():Context= this.ctx

}