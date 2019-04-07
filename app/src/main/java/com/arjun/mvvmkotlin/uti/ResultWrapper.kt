package com.arjun.mvvmkotlin.uti

sealed class ResultWrapper<out R> {
    object Loading:ResultWrapper<Nothing>()
    data class Success<out T>(val data:T) : ResultWrapper<T>()
    data class Error(val throwable: Throwable) : ResultWrapper<Nothing>()
}