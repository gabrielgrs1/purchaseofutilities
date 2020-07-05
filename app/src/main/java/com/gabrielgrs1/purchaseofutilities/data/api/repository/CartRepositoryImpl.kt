package com.gabrielgrs1.purchaseofutilities.data.api.repository

import com.gabrielgrs1.purchaseofutilities.core.api.ErrorResponseHandler.handleApiCallErrors
import com.gabrielgrs1.purchaseofutilities.data.api.service.IApiService
import com.gabrielgrs1.purchaseofutilities.data.mapper.cart.CartListMapper
import com.gabrielgrs1.purchaseofutilities.domain.model.CartListModel
import com.gabrielgrs1.purchaseofutilities.domain.repository.CartRepository
import io.reactivex.Observable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class CartRepositoryImpl : CartRepository, KoinComponent {
    private val iApiService: IApiService by inject()

    override fun getCart(): Observable<CartListModel> = iApiService.getCart()
        .map { response -> CartListMapper.transformTo(response) }
        .onErrorResumeNext(handleApiCallErrors())
}