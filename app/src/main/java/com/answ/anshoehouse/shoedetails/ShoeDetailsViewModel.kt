package com.answ.anshoehouse.shoedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.answ.anshoehouse.shoelist.Shoe

class ShoeDetailsViewModel : ViewModel() {
    private val _shoe: MutableLiveData<Shoe> = MutableLiveData()
    public val shoe
        get() = _shoe

    init {
        _shoe.value = Shoe("",0f)
    }

    
}