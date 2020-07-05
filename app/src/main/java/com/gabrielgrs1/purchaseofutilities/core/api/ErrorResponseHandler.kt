package com.gabrielgrs1.purchaseofutilities.core.api

import android.util.Pair
import com.gabrielgrs1.purchaseofutilities.domain.exception.NetworkException
import com.gabrielgrs1.purchaseofutilities.domain.exception.ServicesDownException
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

object ErrorResponseHandler {
    fun <T> handleApiCallErrors(): Function<Throwable, Observable<T>> {
        return whenExceptionThenReplace<T>(
            Pair(HttpException::class.java, ServicesDownException()),
            Pair(
                SocketTimeoutException::class.java,
                NetworkException()
            ),
            Pair(SSLException::class.java, NetworkException()),
            Pair(UnknownHostException::class.java, NetworkException())
        )
    }

    private fun <T> whenExceptionThenReplace(vararg pairListException: Pair<Class<*>, Throwable>):
            Function<Throwable, Observable<T>> {
        return Function { t: Throwable ->
            for (pair in pairListException) {
                if (pair.first.isInstance(t))
                    return@Function Observable.error<T>(pair.second)
            }
            return@Function Observable.error<T>(t)
        }
    }
}