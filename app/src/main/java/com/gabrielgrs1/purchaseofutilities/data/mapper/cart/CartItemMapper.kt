package com.gabrielgrs1.purchaseofutilities.data.mapper.cart

import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseMapper
import com.gabrielgrs1.purchaseofutilities.data.api.model.response.CartItemResponse
import com.gabrielgrs1.purchaseofutilities.domain.model.CartItemModel

object CartItemMapper : BaseMapper<CartItemResponse, CartItemModel>() {
    override fun transformFrom(s: CartItemModel): CartItemResponse =
        CartItemResponse(
            name = s.name,
            description = s.description,
            imageUrl = s.imageUrl,
            price = s.price,
            quantity = s.quantity,
            shipping = s.shipping,
            stock = s.stock,
            tax = s.tax
        )

    override fun transformTo(s: CartItemResponse): CartItemModel =
        CartItemModel(
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
