package com.gabrielgrs1.purchaseofutilities.presentation.ui

import androidx.fragment.app.Fragment
import com.gabrielgrs1.purchaseofutilities.R
import com.gabrielgrs1.purchaseofutilities.core.plataform.BaseActivity
import com.gabrielgrs1.purchaseofutilities.presentation.ui.cart.CartFragment

class MainActivity : BaseActivity() {
    override fun init() {
        setContentView(R.layout.activity_main)
        startFragment(CartFragment.newInstance())
    }

    private fun startFragment(newInstance: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivityContainerFl, newInstance, newInstance.javaClass.simpleName)
            .commit()
    }
}