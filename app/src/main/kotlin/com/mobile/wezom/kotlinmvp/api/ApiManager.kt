package com.mobile.wezom.kotlinmvp.api

import com.mobile.wezom.kotlinmvp.api.model.UserResponse
import com.mobile.wezom.kotlinmvp.common.RxUtils
import io.reactivex.Observable

/**
 * Created by usik.a on 07.12.2016.
 */
class ApiManager(service: ApiService) {

    val apiService: ApiService = service

    fun getUser(): Observable<UserResponse> {
        return apiService.getUser()
                .compose(RxUtils.applyIOToMainThreadSchedulers())

    }
}