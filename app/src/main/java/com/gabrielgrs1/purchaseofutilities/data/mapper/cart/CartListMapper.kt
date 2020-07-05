package com.gabrielgrs1.purchaseofutilities.data.mapper.cart

import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseMapper
import com.gabrielgrs1.purchaseofutilities.data.api.model.response.CartListResponse
import com.gabrielgrs1.purchaseofutilities.domain.model.CartListModel

object CartListMapper : BaseMapper<CartListResponse, CartListModel>() {
    override fun transformFrom(s: CartListModel): CartListResponse =
        CartListResponse(
            cartListResponse = s.cartListModel.map { CartMapper.transformFrom(it) }
        )

    override fun transformTo(s: CartListResponse): CartListModel =
        CartListModel(
            cartListModel = s.cartListResponse.map { CartMapper.transformTo(it) }
        )
}
