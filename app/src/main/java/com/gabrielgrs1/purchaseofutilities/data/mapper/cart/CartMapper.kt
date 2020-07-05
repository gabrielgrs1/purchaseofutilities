package com.gabrielgrs1.purchaseofutilities.data.mapper.cart

import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseMapper
import com.gabrielgrs1.purchaseofutilities.data.api.model.response.CartListResponse
import com.gabrielgrs1.purchaseofutilities.data.api.model.response.CartResponse
import com.gabrielgrs1.purchaseofutilities.domain.model.CartModel

object CartMapper : BaseMapper<CartResponse, CartModel>() {
    override fun transformFrom(s: CartModel): CartResponse =
        CartResponse(
            name = s.name,
            description = s.description,
            imageUrl = s.imageUrl,
            price = s.price,
            quantity = s.quantity,
            shipping = s.shipping,
            stock = s.stock,
            tax = s.tax
        )

    override fun transformTo(s: CartResponse): CartModel =
        CartModel(
            name = s.name,
            description = s.description,
            imageUrl = s.imageUrl,
            price = s.price,
            quantity = s.quantity,
            shipping = s.shipping,
            stock = s.stock,
            tax = s.tax
        )
}
