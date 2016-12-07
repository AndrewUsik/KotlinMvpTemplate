package com.mobile.wezom.kotlinmvp.mvp.presenter

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.mobile.wezom.kotlinmvp.App
import com.mobile.wezom.kotlinmvp.di.components.ApplicationComponent

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by usik.a on 11.11.2016.
 */

open class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    private val disposables = CompositeDisposable()

    protected fun unsubscribeOnDestroy(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

       fun getAppComponent(): ApplicationComponent = App.mApplicationComponent
}
