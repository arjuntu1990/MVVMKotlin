package com.arjun.mvvmkotlin.ui

import androidx.lifecycle.ViewModel
import com.arjun.mvvmkotlin.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ModuleEmployeeList {

    @Binds
    @IntoMap
    @ViewModelKey(VMEmployee::class)
    abstract fun bindVMEmployee(viewModel:VMEmployee) : ViewModel
}