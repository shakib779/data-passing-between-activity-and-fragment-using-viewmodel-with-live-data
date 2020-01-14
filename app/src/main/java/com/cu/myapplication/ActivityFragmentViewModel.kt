package com.cu.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityFragmentViewModel : ViewModel() {
    var name = MutableLiveData<String>("")

    fun setValue(string: String) {
        name.value = string
    }
}