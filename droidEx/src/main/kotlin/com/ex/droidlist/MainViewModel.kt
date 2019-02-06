package com.ex.droidlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _isFormValid = MutableLiveData<Boolean>()

    val isFormValid: LiveData<Boolean>
        get() = _isFormValid

    var username = ""
        set(value) {
            field = value
            validateForm()
        }

    var password = ""
        set(value) {
            field = value
            validateForm()
        }

    private fun validateForm() {
        if (username.length > 8 && password.length > 8) {
            _isFormValid.postValue(true)
        } else {
            _isFormValid.postValue(false)
        }
    }
}