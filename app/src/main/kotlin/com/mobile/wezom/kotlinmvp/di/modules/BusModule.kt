package com.mobile.wezom.kotlinmvp.di.modules

import dagger.Module
import dagger.Provides
import de.greenrobot.event.EventBus
import javax.inject.Singleton

/**
 * Created by usik.a on 07.12.2016.
 */
@Module
class BusModule {
    @Provides
    @Singleton
    fun provideBus(): EventBus {
        return EventBus()
    }
}