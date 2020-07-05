package com.gabrielgrs1.purchaseofutilities.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseViewModel
import com.gabrielgrs1.purchaseofutilities.presentation.model.CartItem

class DetailViewModel : BaseViewModel() {
    val cartItemLiveData: MutableLiveData<CartItem> = MutableLiveData()
    val cartItemStock: MutableLiveData<String> = MutableLiveData()

    fun setCartItem(cartItem: CartItem) {
        cartItemLiveData.value = cartItem
        setCartItemStock()
    }

    private fun setCartItemStock() {
        cartItemStock.value = if (cartItemLiveData.value?.stock == 1) {
            "only 1 left in stock" //TODO Passar pro strings
        } else {
            "in stock"
        }
    }

}