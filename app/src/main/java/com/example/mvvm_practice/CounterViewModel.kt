package com.example.mvvm_practice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import java.lang.reflect.Array.get

class CounterViewModel : ViewModel() {

    var count : MutableLiveData<Int> = MutableLiveData()

    init {
        count.value = 0
    }

    fun increase(){
        count.setValue(count.getValue()?.plus(1))
    }

    fun decrease(){
        count.setValue(count.getValue()?.minus(1))
    }

}