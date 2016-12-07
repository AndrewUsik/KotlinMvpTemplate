package com.mobile.wezom.kotlinmvp.api.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose



/**
 * Created by usik.a on 07.12.2016.
 */
class UserResponse {

    @SerializedName("userId")
    @Expose
    var userId: Int? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("body")
    @Expose
    var body: String? = null
}