package com.mobile.wezom.kotlinmvp

import android.app.Application
import com.mobile.wezom.kotlinmvp.di.components.ApplicationComponent
import com.mobile.wezom.kotlinmvp.di.components.DaggerApplicationComponent
import com.mobile.wezom.kotlinmvp.di.modules.ApiModule
import com.mobile.wezom.kotlinmvp.di.modules.BusModule
import com.mobile.wezom.kotlinmvp.di.modules.ContextModule
import timber.log.Timber

/**
 * Created by usik.a on 07.12.2016.
 */
open class App : Application() {

    companion object {
        @JvmStatic lateinit var mApplicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        createApplicationComponent()
        Timber.plant(Timber.DebugTree())
        super.onCreate()
    }

    private fun createApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .apiModule(ApiModule())
                .contextModule(ContextModule(this))
                .busModule(BusModule())
                .build();
    }
}