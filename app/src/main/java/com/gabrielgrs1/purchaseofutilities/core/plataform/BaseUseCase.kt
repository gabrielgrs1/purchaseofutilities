package com.gabrielgrs1.purchaseofutilities.core.plataform

import io.reactivex.Observable
import org.koin.standalone.KoinComponent

abstract class BaseUseCase<in RV : BaseRequestValues, T> : KoinComponent {
    private var requestValue: RV? = null

    fun setRequestValues(requestValues: RV?) {
        this.requestValue = requestValues
    }

    fun run(): Observable<T> {
        return executeUseCase(requestValue)
    }

    abstract fun executeUseCase(requestValues: RV? = null): Observable<T>
}
