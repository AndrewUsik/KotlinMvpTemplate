package com.mobile.wezom.kotlinmvp.mvp.presenter

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.mobile.wezom.kotlinmvp.mvp.view.HomeActivityView
import de.greenrobot.event.EventBus
import javax.inject.Inject

/**
 * Created by usik.a on 07.12.2016.
 */

@InjectViewState
class HomeActivityPresenter() : BasePresenter<HomeActivityView>() {

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var bus: EventBus

    init {
        getAppComponent().inject(this)
    }

}