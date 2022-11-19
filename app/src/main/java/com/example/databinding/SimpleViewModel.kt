package com.example.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Oscar Arce
 * on 31/10/2022.
 */
class SimpleViewModel: ViewModel() {
    var nextNumber: MutableLiveData<Long> = MutableLiveData(1)
    var fibonacci: MutableLiveData<String> = MutableLiveData("0")
    private var number1: Long = 0
    private var number2: Long = 0

    fun onResult() {
        number1 = number2
        number2 = nextNumber.value!!.toLong()
        nextNumber.postValue(number1 + number2)
        val post = fibonacci.value.plus(" - ${nextNumber.value}")
        fibonacci.postValue(post)
    }
}
