package com.gabrielgrs1.purchaseofutilities.data.api.model.response

import com.google.gson.annotations.SerializedName

data class CartItemResponse(
    @SerializedName("name") val name: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("stock") val stock: Int,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("price") val price: Double,
    @SerializedName("tax") val tax: Double,
    @SerializedName("shipping") val shipping: Double,
    @SerializedName("description") val description: String
)