package com.arjun.mvvmkotlin.uti

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import java.net.*

open class BaseActivity : DaggerAppCompatActivity() {

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
    }*/

    protected fun onError(throwable: Throwable) {
        when(throwable) {
            is UnknownHostException -> Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show()
            is SocketTimeoutException -> Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show()
            is ConnectException -> Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show()
            is NoRouteToHostException -> Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show()
            is SocketException -> Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show()
        }
    }

    protected inline fun <reified VM : ViewModel> viewModelProvider(
        provider: ViewModelProvider.Factory
    ) =
        ViewModelProviders.of(this, provider).get(VM::class.java)
}
