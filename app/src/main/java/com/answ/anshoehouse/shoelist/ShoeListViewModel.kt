package com.answ.anshoehouse.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {
    private lateinit var _shoesList: MutableList<Shoe>;
    public val shoesList: MutableList<Shoe>
    get() = _shoesList
    init {
        getShoes()
    }

    private fun getShoes(): Unit {
        Log.d("getShoes", "Shoes list retrieved")
        _shoesList = mutableListOf<Shoe>()
        for (i in 0..10) {
            _shoesList.add(Shoe("Show $i", i.toFloat()))
        }
    }
}

data class Shoe(val name: String, val price: Float)