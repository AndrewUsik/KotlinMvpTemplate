package com.mobile.wezom.kotlinmvp.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by usik.a on 07.12.2016.
 */

@Module
class ContextModule(context: Context) {
    var mContext: Context = context


    fun ContextModule(context: Context) {
        mContext = context
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return mContext
    }
}