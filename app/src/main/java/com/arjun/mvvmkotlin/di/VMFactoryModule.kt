package com.arjun.mvvmkotlin.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class VMFactoryModule {
    @Binds
    internal abstract fun bindVMFactory(factory:MyVMFactory) : ViewModelProvider.Factory
}