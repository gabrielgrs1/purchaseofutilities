package com.gabrielgrs1.purchaseofutilities.core.extensions

import androidx.lifecycle.MutableLiveData
import com.gabrielgrs1.purchaseofutilities.core.plataform.Either
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.text.NumberFormat
import java.util.Locale

fun <T> Observable<T>.subscribeEither(liveData: MutableLiveData<Either<Throwable, T>>): Disposable {
    return this.subscribe({
        liveData.value = Either.Right(it)
    }, {
        liveData.value = Either.Left(it)
    })
}

fun Double.toCurrency(): String {
    val numberReduce = this/100
    val format = NumberFormat.getCurrencyInstance(Locale.US)
    return format.format(numberReduce)
}
