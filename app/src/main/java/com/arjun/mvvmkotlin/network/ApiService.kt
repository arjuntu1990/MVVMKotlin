package com.arjun.mvvmkotlin.network

import com.arjun.mvvmkotlin.uti.Employee
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("employees")
    fun getEmployees() : Single<List<Employee>>
}