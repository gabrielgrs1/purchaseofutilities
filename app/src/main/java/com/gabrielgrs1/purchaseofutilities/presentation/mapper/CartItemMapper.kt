package com.gabrielgrs1.purchaseofutilities.presentation.mapper

import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseMapper
import com.gabrielgrs1.purchaseofutilities.domain.model.CartItemModel
import com.gabrielgrs1.purchaseofutilities.presentation.model.CartItem

object CartItemMapper : BaseMapper<CartItemModel, CartItem>() {
    override fun transformFrom(s: CartItem): CartItemModel =
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

    override fun transformTo(s: CartItemModel): CartItem =
        CartItem(
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
