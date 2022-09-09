package com.answ.anshoehouse.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    init {
        _email.value = ""
        _password.value = ""
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun login(): Boolean {
        if (email.value?.length == 0)
            return false
        if (password.value?.length == 0)
            return false
        return true
    }
}