package com.arjun.mvvmkotlin.uti

import io.reactivex.Single

abstract class UseCase<in P,R> {
    abstract fun execute(p : P) : Single<R>
}