package com.udacity.shoestore.screens.shoeList

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_list_item.view.*

class ShoeLayout(context: Context?) : LinearLayout(context) {

    private val binding: ShoeListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_list_item, this, false)

    fun createShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            shoeItem = shoe
        }
    }
}