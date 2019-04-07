package com.arjun.mvvmkotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arjun.mvvmkotlin.R
import com.arjun.mvvmkotlin.uti.Employee
import kotlinx.android.synthetic.main.employee_item.view.*

class EmployeesRvAdap(private val list:List<Employee>) : RecyclerView.Adapter<EmployeesRvAdap.EmployeeVh>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeVh {
        return EmployeeVh(LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: EmployeeVh, position: Int) {
        holder.itemView.run {
            val employee = list[position]
            tv_name.text = employee.employee_name
            tv_id.text = employee.id
        }
    }

    class EmployeeVh(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}