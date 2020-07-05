package com.gabrielgrs1.purchaseofutilities.presentation.ui.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.gabrielgrs1.purchaseofutilities.R
import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseFragment
import com.gabrielgrs1.purchaseofutilities.databinding.FragmentDetailBinding
import com.gabrielgrs1.purchaseofutilities.presentation.model.CartItem
import kotlinx.android.synthetic.main.fragment_detail.detailFragmentPictureIv
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private var cartItem: CartItem? = null
    private val mDetailViewModel: DetailViewModel by viewModel()

    override fun getContentLayoutId(): Int = R.layout.fragment_detail

    override fun init() {
        getCartItemBundle()
        initBind()
        setCartItem()
        setImage()
    }

    private fun setCartItem() {
        cartItem?.let {
            mDetailViewModel.setCartItem(it)
        }
    }

    private fun setImage() {
        Glide.with(requireContext())
            .load(mDetailViewModel.cartItemLiveData.value?.imageUrl)
            .thumbnail(0.02f)
            .into(detailFragmentPictureIv)
    }

    private fun initBind() {
        binding.lifecycleOwner = this
        binding.viewModel = mDetailViewModel

    }

    private fun getCartItemBundle() {
        arguments?.let {
            cartItem = it.getSerializable(CART_ITEM_PARAM) as CartItem
        }
    }

    companion object {
        fun newInstance(cartItem: CartItem) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(CART_ITEM_PARAM, cartItem)
                }
            }

        private const val CART_ITEM_PARAM = "cartItemParam"
    }
}