package com.arjun.mvvmkotlin.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class MyVMFactory @Inject constructor(
    private val vmFactoryCreators
    :@JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val entry = vmFactoryCreators.entries.find { modelClass.isAssignableFrom(it.key) }
        val creator= entry?.value
            ?: throw IllegalArgumentException("model class not found :" + modelClass)
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}