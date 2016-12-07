package com.mobile.wezom.kotlinmvp.di.modules

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mobile.wezom.kotlinmvp.api.ApiManager
import com.mobile.wezom.kotlinmvp.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by usik.a on 07.12.2016.
 */
@Module
class ApiModule {

    private val DISK_CACHE_SIZE = 10 * 1024 * 1024

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiManager(service: ApiService): ApiManager {
        return ApiManager(service)
    }


    @Provides
    @Singleton
    internal fun provideOkHttpClient(context: Context): OkHttpClient {
        return createOkHttpClient(context)
    }

    private fun createOkHttpClient(context: Context): OkHttpClient {
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, DISK_CACHE_SIZE.toLong())
        return OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
    }
}