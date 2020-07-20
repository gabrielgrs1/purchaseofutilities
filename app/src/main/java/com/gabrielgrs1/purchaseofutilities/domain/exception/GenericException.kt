package com.gabrielgrs1.purchaseofutilities.domain.exception

open class GenericException : Exception {

    constructor(message: String) : super(message)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return this.message.equals((other as Exception).message)
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}