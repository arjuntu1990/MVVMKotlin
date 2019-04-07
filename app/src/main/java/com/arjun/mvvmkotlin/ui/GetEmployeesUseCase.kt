package com.arjun.mvvmkotlin.ui

import com.arjun.mvvmkotlin.uti.Employee
import com.arjun.mvvmkotlin.uti.UseCase
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetEmployeesUseCase @Inject constructor(private val repository: EmployeeRepository) : UseCase<Unit, List<Employee>>() {
    override fun execute(p: Unit): Single<List<Employee>> {
        return repository.getEmployees().subscribeOn(Schedulers.io())
    }
}