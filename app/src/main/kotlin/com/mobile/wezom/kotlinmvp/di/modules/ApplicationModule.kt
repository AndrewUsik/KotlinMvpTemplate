package com.mobile.wezom.kotlinmvp.di.modules

import android.app.Application
import android.content.Context
import com.mobile.wezom.kotlinmvp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by usik.a on 07.12.2016.
 */

@Module(includes = arrayOf(ApiModule::class))
 class ApplicationModule {
     lateinit internal var application: Application

    fun ApplicationModule(app: App) {
        application = app
    }

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return application.applicationContext
    }
}