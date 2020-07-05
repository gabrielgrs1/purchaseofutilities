package com.gabrielgrs1.purchaseofutilities.domain.usecase

import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseRequestValues
import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseUseCase
import com.gabrielgrs1.purchaseofutilities.domain.repository.CartRepository
import com.gabrielgrs1.purchaseofutilities.presentation.mapper.CartListMapper
import com.gabrielgrs1.purchaseofutilities.presentation.model.CartList
import io.reactivex.Observable
import org.koin.standalone.inject

open class CartUseCase : BaseUseCase<BaseRequestValues, CartList>() {

    private val cartRepository: CartRepository by inject()

    override fun executeUseCase(requestValues: BaseRequestValues?): Observable<CartList> {
        return cartRepository.getCart().map { response -> CartListMapper.transformTo(response) }
    }
}