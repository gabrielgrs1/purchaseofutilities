package com.gabrielgrs1.purchaseofutilities.presentation.model

import java.io.Serializable

class CartItem(
    val name: String,
    val quantity: Int,
    val stock: Int,
    val imageUrl: String,
    val price: Double,
    val tax: Double,
    val shipping: Double,
    val description: String
) : Serializable