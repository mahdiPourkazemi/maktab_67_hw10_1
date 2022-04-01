package com.pourkazemi.mahdi.maktab_hw10_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _bList = MutableLiveData<MutableList<Boolean>>()
    val bList: LiveData<List<Boolean>> get() = Transformations.map(_bList) { it.toList() }

    fun addToList(index:Int,cheated:Boolean){
        _bList.value?.add(index,cheated)
    }
}

