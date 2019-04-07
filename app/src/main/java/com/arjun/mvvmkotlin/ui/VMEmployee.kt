package com.arjun.mvvmkotlin.ui

import androidx.lifecycle.MutableLiveData
import com.arjun.mvvmkotlin.uti.BaseVM
import com.arjun.mvvmkotlin.uti.Employee
import com.arjun.mvvmkotlin.uti.ResultWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class VMEmployee @Inject constructor(private val useCase: GetEmployeesUseCase) : BaseVM() {
    private val _employeeHolder = MutableLiveData<ResultWrapper<List<Employee>>>()
    val employeeHolder = _employeeHolder

    fun getEmployees() {
        compositeDisposable.add(useCase.execute(Unit)
            .doOnSubscribe {
                _employeeHolder.postValue(ResultWrapper.Loading)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _employeeHolder.postValue(ResultWrapper.Success(it))
            },{
                                _employeeHolder.postValue(ResultWrapper.Error(it))
            }))
    }
}