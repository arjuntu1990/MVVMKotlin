package com.arjun.mvvmkotlin.di

import com.arjun.mvvmkotlin.network.ApiService
import com.arjun.mvvmkotlin.network.HeaderInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory,
                         callAdapterFactory: RxJava2CallAdapterFactory) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com/api/v1/")
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun providesGsonConverterFactory() : GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun providesRxCallAdapterFacory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun providesLoggingInterceptor() : HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Singleton
    @Provides
    fun providesHeaderInterceptor() : HeaderInterceptor {
        return HeaderInterceptor()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(loggingInterceptor:HttpLoggingInterceptor,
                             headerInterceptor: HeaderInterceptor) : OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headerInterceptor)
            .connectTimeout(0, TimeUnit.SECONDS)
            .readTimeout(0,TimeUnit.SECONDS)
            .writeTimeout(0, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }
}