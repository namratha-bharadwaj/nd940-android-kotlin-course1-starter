package com.udacity.shoestore.screens.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.*

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addShoe(item: Shoe) {
        item?.run {
            _shoeList.value?.add(this)
        }
    }
}