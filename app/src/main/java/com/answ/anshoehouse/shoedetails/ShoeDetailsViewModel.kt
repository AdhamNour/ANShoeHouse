package com.answ.anshoehouse.shoedetails

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.answ.anshoehouse.shoelist.Shoe

class ShoeDetailsViewModel : ViewModel() {
    val name = MutableLiveData<String>()

    val price = MutableLiveData<String>()

}