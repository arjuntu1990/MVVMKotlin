package com.arjun.mvvmkotlin.ui

import com.arjun.mvvmkotlin.network.ApiService
import com.arjun.mvvmkotlin.uti.Employee
import io.reactivex.Single
import javax.inject.Inject

class EmployeeRepository @Inject constructor(private val apiService: ApiService) {
    fun getEmployees(): Single<List<Employee>> {
        return apiService.getEmployees()
    }
}