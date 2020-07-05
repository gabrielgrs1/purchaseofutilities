package com.gabrielgrs1.purchaseofutilities.core.api

import com.gabrielgrs1.purchaseofutilities.core.util.Constants.Companion.BASE_URL
import com.gabrielgrs1.purchaseofutilities.data.api.service.IApiService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun provideApi(retrofit: Retrofit): IApiService = retrofit.create(IApiService::class.java)

fun provideRetrofit(): Retrofit {
    lateinit var retrofit: Retrofit
    val client = OkHttpClient.Builder()
    addLoggingInterceptor(client)

    retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(client.build())
        .build()

    return retrofit
}

private fun addLoggingInterceptor(client: OkHttpClient.Builder) {
    client.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
}
