package com.answ.anshoehouse.shoe_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.answ.anshoehouse.shoelist.Shoe

class ShoeDetailsViewModel : ViewModel() {
    private val _shoe: MutableLiveData<Shoe> = MutableLiveData()
    public val shoe
        get() = _shoe

    public fun updateShoe(name: String?, price: Float?) {
        _shoe.value = _shoe.value?.copyWith(name, price)
    }
}