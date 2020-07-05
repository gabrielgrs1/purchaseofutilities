package com.gabrielgrs1.purchaseofutilities.data.api.service

import com.gabrielgrs1.purchaseofutilities.data.api.model.response.CartListResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface IApiService {
    @GET("data.json")
    fun getCart(): Observable<CartListResponse>
}