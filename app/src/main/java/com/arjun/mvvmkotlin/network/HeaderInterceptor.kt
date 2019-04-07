package com.arjun.mvvmkotlin.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request()
            .newBuilder()
            .addHeader("token", "dummy header token")
            .build())
    }
}