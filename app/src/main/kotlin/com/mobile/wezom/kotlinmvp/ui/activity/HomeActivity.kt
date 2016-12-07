package com.mobile.wezom.kotlinmvp.ui.activity

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.mobile.wezom.kotlinmvp.R
import com.mobile.wezom.kotlinmvp.mvp.presenter.HomeActivityPresenter
import com.mobile.wezom.kotlinmvp.mvp.view.HomeActivityView
import com.mobile.wezom.kotlinmvp.ui.fragment.HomeFragment

class HomeActivity : BaseActivity(), HomeActivityView {

    @InjectPresenter
    lateinit var presenter: HomeActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        switchFragment(HomeFragment())
    }

    override fun getLayoutRes(): Int = R.layout.activity_home
}
