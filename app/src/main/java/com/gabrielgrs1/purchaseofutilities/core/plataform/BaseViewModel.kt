package com.gabrielgrs1.purchaseofutilities.core.plataform

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.standalone.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {

    protected val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
