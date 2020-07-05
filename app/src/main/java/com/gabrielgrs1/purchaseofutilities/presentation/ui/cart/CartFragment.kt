package com.gabrielgrs1.purchaseofutilities.presentation.ui.cart

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabrielgrs1.purchaseofutilities.R
import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseFragment
import com.gabrielgrs1.purchaseofutilities.core.plataform.fold
import com.gabrielgrs1.purchaseofutilities.databinding.FragmentCartBinding
import com.gabrielgrs1.purchaseofutilities.presentation.model.CartItem
import com.gabrielgrs1.purchaseofutilities.presentation.ui.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_cart.cartActivityCartRv
import kotlinx.android.synthetic.main.fragment_cart.cartActivityQuantityItemsTv
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : BaseFragment<FragmentCartBinding>(), CartAdapter.CartListener {

    private val mCartViewModel: CartViewModel by viewModel()
    private lateinit var mCartAdapter: CartAdapter

    companion object {
        fun newInstance() = CartFragment()
    }

    override fun getContentLayoutId(): Int = R.layout.fragment_cart

    override fun init() {
        initBind()
        subscribeLiveData()
        getCart()
        initRecyclerView()
    }

    private fun getCart() {
        mCartViewModel.getCart()
    }

    private fun initBind() {
        binding.viewModel = mCartViewModel
        binding.lifecycleOwner = this
    }

    override fun onClickItemCart(cartItem: CartItem) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.mainActivityContainerFl,
            DetailFragment.newInstance(cartItem),
            DetailFragment::class.simpleName
        )?.addToBackStack(null)?.commit()
    }

    private fun initRecyclerView() {
        mCartAdapter = CartAdapter(listener = this)
        cartActivityCartRv.layoutManager = LinearLayoutManager(requireContext())
        cartActivityCartRv.adapter = mCartAdapter
    }

    private fun subscribeLiveData() {
        mCartViewModel.cartItemListResponse.observe(this, Observer { response ->
            response?.fold(this::handleError, this::handleSuccess)
        })
    }

    private fun handleSuccess(cartItemList: List<CartItem>) {
        setTotalItems(cartItemList)
        mCartAdapter.updateCartList(cartItemList)
        mCartViewModel.setTax(cartItemList)
        mCartViewModel.setShipping(cartItemList)
        mCartViewModel.setTotal(cartItemList)
        mCartViewModel.setSubtotal(cartItemList)
    }

    private fun setTotalItems(cartItemList: List<CartItem>) {
        val quantityItems = if (cartItemList.isNotEmpty()) cartItemList.size else 0
        cartActivityQuantityItemsTv.text = getString(R.string.quantity_items_cart, quantityItems)
    }
}
