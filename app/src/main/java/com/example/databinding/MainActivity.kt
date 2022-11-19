package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: SimpleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[SimpleViewModel::class.java]

        dataBinding.viewmodel = viewModel

        viewModel.nextNumber.observe(this, Observer {
            dataBinding.etNext.setText(it.toString())
        })

        viewModel.fibonacci.observe(this, Observer {
            dataBinding.etFibonacci.setText(it.toString())
        })
    }
}