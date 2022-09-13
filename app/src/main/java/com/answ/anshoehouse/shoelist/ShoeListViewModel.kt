package com.answ.anshoehouse.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {
    private  val _shoesList: MutableLiveData<List<Shoe>> = MutableLiveData()
    public val shoesList: LiveData<List<Shoe>>
    get() = _shoesList
    init {
        getShoes()
    }

    private fun getShoes(): Unit {
        Log.d("getShoes", "Shoes list retrieved")
        val list : MutableList<Shoe> = mutableListOf()
        for (i in 0..10) {
            list.add(Shoe("Show $i", i.toFloat()))
        }
        _shoesList.value=list.toList()
    }
    public fun addShoe(shoe:Shoe){
        val currentList:MutableList<Shoe> = _shoesList.value?.toMutableList()?: mutableListOf()
        currentList.add(shoe)
        _shoesList.value=currentList
    }
}

data class Shoe(val name: String, val price: Float){
    fun copyWith(newName: String?,newPrice:Float?):Shoe{
        return Shoe(newName?:name,newPrice?:price)
    }
}