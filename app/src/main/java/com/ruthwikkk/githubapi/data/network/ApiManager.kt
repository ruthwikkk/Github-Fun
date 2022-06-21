package com.ruthwikkk.githubapi.data.network

import com.ruthwikkk.githubapi.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ApiManager {

    var api : Api

    init {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val interceptor = HttpLoggingInterceptor()

        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE


        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .build()

        val restAdapter = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()
        api = restAdapter.create(Api::class.java)
    }
}
