package com.arjun.mvvmkotlin.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arjun.mvvmkotlin.R
import com.arjun.mvvmkotlin.uti.BaseActivity
import com.arjun.mvvmkotlin.uti.LoadingDialog
import com.arjun.mvvmkotlin.uti.ResultWrapper
import kotlinx.android.synthetic.main.activity_employee_list.*
import javax.inject.Inject

class EmployeeListActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory:ViewModelProvider.Factory

    lateinit var vmEmployee:VMEmployee

    private val loadingDialog by lazy {
        LoadingDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)
        initViews()
        observeEmployees()
    }

    private fun initViews() {
        vmEmployee = viewModelProvider(viewModelFactory)

        rv_employees.layoutManager = LinearLayoutManager(this)

        vmEmployee.getEmployees()
    }

    private fun observeEmployees() {
        vmEmployee.employeeHolder.observe(this, Observer {
            when (it) {
                is ResultWrapper.Loading -> loadingDialog.toggle(true)
                is ResultWrapper.Success -> {
                    loadingDialog.toggle(false)
                    rv_employees.adapter = EmployeesRvAdap(it.data)
                }
                is ResultWrapper.Error -> {
                    loadingDialog.toggle(false)
                    onError(it.throwable)
                }
            }
        })
    }
}