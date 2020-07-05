package com.gabrielgrs1.purchaseofutilities.domain.repository

import com.gabrielgrs1.purchaseofutilities.domain.model.CartItemModel
import io.reactivex.Observable

interface CartRepository {
    fun getCart(): Observable<List<CartItemModel>>
}