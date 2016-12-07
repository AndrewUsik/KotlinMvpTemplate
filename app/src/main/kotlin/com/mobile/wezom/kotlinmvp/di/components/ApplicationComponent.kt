package com.mobile.wezom.kotlinmvp.di.components

import com.mobile.wezom.kotlinmvp.di.modules.ApiModule
import com.mobile.wezom.kotlinmvp.di.modules.BusModule
import com.mobile.wezom.kotlinmvp.di.modules.ContextModule
import com.mobile.wezom.kotlinmvp.mvp.presenter.HomeActivityPresenter
import com.mobile.wezom.kotlinmvp.mvp.presenter.HomeFragmentPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by usik.a on 07.12.2016.
 */

@Singleton
@Component(modules = arrayOf(ApiModule::class, ContextModule::class, BusModule::class))
interface ApplicationComponent {

    fun inject(homeActivityPresenter: HomeActivityPresenter)
    fun inject(homeFragmentPresenter: HomeFragmentPresenter)

}