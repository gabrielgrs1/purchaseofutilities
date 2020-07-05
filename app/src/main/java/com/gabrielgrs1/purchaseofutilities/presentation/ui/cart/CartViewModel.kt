package com.gabrielgrs1.purchaseofutilities.presentation.ui.cart

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gabrielgrs1.purchaseofutilities.core.extensions.toCurrency
import com.gabrielgrs1.purchaseofutilities.core.extensions.subscribeEither
import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseViewModel
import com.gabrielgrs1.purchaseofutilities.core.plataform.Either
import com.gabrielgrs1.purchaseofutilities.core.util.UseCaseHandler
import com.gabrielgrs1.purchaseofutilities.domain.requestvalues.CartRequestValue
import com.gabrielgrs1.purchaseofutilities.domain.usecase.CartUseCase
import com.gabrielgrs1.purchaseofutilities.presentation.model.CartItem
import org.koin.standalone.inject

class CartViewModel : BaseViewModel() {

    private val mCartUseCase: CartUseCase by inject()
    val cartItemListResponse: MutableLiveData<Either<Throwable, List<CartItem>>> = MutableLiveData()
    val taxLiveData: MutableLiveData<String> = MutableLiveData()
    val shippingLiveData: MutableLiveData<String> = MutableLiveData()
    val subtotalValueLiveData: MutableLiveData<String> = MutableLiveData()
    val totalValueLiveData: MutableLiveData<String> = MutableLiveData()

    fun getCart() {
        Log.d(CartViewModel::class.java.name, "Get cart items")

        val cartRequestValues = CartRequestValue()
        val useCase = UseCaseHandler.execute(mCartUseCase, cartRequestValues)

        compositeDisposable.add(useCase.subscribeEither(cartItemListResponse))
    }

    fun setTax(cartItemList: List<CartItem>) {
        var taxValue = 0.0
        cartItemList.map { taxValue += it.tax }
        taxLiveData.apply { value = taxValue.toCurrency() }
    }

    fun setShipping(cartItemList: List<CartItem>) {
        var shippingValue = 0.0
        cartItemList.map { shippingValue += it.shipping }
        shippingLiveData.apply { value = shippingValue.toCurrency() }
    }

    fun setSubtotal(cartItemList: List<CartItem>) {
        var subtotalValue = 0.0
        cartItemList.map { subtotalValue += it.price }
        subtotalValueLiveData.apply { value = subtotalValue.toCurrency() }
    }

    fun setTotal(cartItemList: List<CartItem>) {
        var totalValue = 0.0
        cartItemList.map { totalValue += it.price }
        cartItemList.map { totalValue += it.tax }
        cartItemList.map { totalValue += it.shipping }
        totalValueLiveData.apply { value = totalValue.toCurrency() }
    }

}
