package com.mobile.wezom.kotlinmvp.ui.fragment

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.mobile.wezom.kotlinmvp.R
import com.mobile.wezom.kotlinmvp.mvp.presenter.HomeFragmentPresenter
import com.mobile.wezom.kotlinmvp.mvp.view.HomeFragmentView
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment(), HomeFragmentView {

    @InjectPresenter
    lateinit var presenter: HomeFragmentPresenter

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getUser()
    }

    override fun setText(text: String) {
        tv.text = text
    }

}
