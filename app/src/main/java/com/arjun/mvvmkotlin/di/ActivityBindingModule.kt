package com.arjun.mvvmkotlin.di

import com.arjun.mvvmkotlin.ui.EmployeeListActivity
import com.arjun.mvvmkotlin.ui.ModuleEmployeeList
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivitScoped
    @ContributesAndroidInjector(modules = [ModuleEmployeeList::class])
    internal abstract fun bindEmployeeActivity() : EmployeeListActivity
}