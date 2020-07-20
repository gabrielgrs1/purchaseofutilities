package com.gabrielgrs1.purchaseofutilities.presentation.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gabrielgrs1.purchaseofutilities.R
import com.gabrielgrs1.purchaseofutilities.core.extensions.toCurrency
import com.gabrielgrs1.purchaseofutilities.presentation.model.CartItem
import kotlinx.android.synthetic.main.item_cart.view.*

class CartAdapter(
    private var cartItemList: List<CartItem>? = null,
    private val listener: CartListener
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int = if (cartItemList.isNullOrEmpty()) {
        0
    } else {
        cartItemList!!.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        cartItemList?.get(position)?.let { holder.bindView(it) }

        holder.itemView.setOnClickListener {
            listener.onClickItemCart()
        }

        //TODO Testar
        if (position == 0) holder.showTopDivider()
    }

    fun updateCartList(cartItemList: List<CartItem>) {
        this.cartItemList = cartItemList
        notifyDataSetChanged()
    }

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(cartItemItem: CartItem) {
            setTextFields(cartItemItem)
            setImage(cartItemItem.imageUrl)
        }

        private fun setImage(imageUrl: String?) {
            if (imageUrl != null) {
                Glide.with(itemView.context)
                    .load(imageUrl)
                    .thumbnail(0.02f)
                    .into(itemView.itemCartItemPictureIv)
            }
        }

        fun showTopDivider() {
            itemView.itemCartTopDividerV.visibility = View.VISIBLE
        }

        private fun setTextFields(itemCartItem: CartItem) {
            itemView.itemCartItemNameTv.text = itemCartItem.name
            itemView.itemCartItemStockTv.text = getStockDescription(itemCartItem.stock)
            itemView.itemCartValueTv.text = itemCartItem.price.toCurrency()
        }

        private fun getStockDescription(itemCartStock: Int): String {
            return if (itemCartStock == 1) {
                "only 1 left in stock" //TODO Passar pro strings
            } else {
                "in stock"
            }
        }
    }

    interface CartListener {
        fun onClickItemCart()
    }
}