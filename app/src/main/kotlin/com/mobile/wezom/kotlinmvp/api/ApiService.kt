package com.mobile.wezom.kotlinmvp.api

import com.mobile.wezom.kotlinmvp.api.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by usik.a on 07.12.2016.
 */
interface ApiService {

    @GET("/posts/1")
    fun getUser(): Observable<UserResponse>
}