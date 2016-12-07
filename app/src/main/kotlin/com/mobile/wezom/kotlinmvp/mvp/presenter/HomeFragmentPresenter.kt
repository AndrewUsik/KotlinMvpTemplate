package com.mobile.wezom.kotlinmvp.mvp.presenter

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.mobile.wezom.kotlinmvp.api.ApiManager
import com.mobile.wezom.kotlinmvp.mvp.view.HomeFragmentView
import de.greenrobot.event.EventBus
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by usik.a on 07.12.2016.
 */

@InjectViewState
class HomeFragmentPresenter : BasePresenter<HomeFragmentView>() {

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var apiManager: ApiManager

    @Inject
    lateinit var bus: EventBus

    init {
        getAppComponent().inject(this)
    }

    fun getUser() {
        apiManager.getUser()
                .subscribe({ list ->
                    viewState.setText(list.title as String)
                }, { throwable -> Timber.e("get user request ", throwable) })
    }
}