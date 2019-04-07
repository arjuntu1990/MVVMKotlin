package com.arjun.mvvmkotlin.di

import com.arjun.mvvmkotlin.MainApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        VMFactoryModule::class]
)
interface AppComponent : AndroidInjector<MainApp> {
    @Component.Builder
    abstract class Builder() : AndroidInjector.Builder<MainApp>()
}