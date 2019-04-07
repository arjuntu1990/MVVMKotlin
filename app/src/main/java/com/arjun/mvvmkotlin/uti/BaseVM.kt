package com.arjun.mvvmkotlin.uti

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseVM : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}